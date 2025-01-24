package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.hibernate.boot.internal.BootstrapContextImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaSubqueryImpl;
import org.hibernate.query.criteria.internal.path.CollectionAttributeJoin;
import org.hibernate.query.criteria.internal.path.ListAttributeJoin;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
import org.hibernate.query.criteria.internal.predicate.NegatedPredicateWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuRestrictionFactoryImplDiffblueTest {
  @Autowired
  private SkuRestrictionFactoryImpl skuRestrictionFactoryImpl;

  /**
   * Test {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}.
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRestriction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7505 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuRestrictionFactoryImpl skuRestrictionFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuRestrictionFactoryImpl()).getRestriction("Type", "42");
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}.
   * <ul>
   *   <li>Then calls {@link Restriction#getFilterValueConverter()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  public void testGetRestriction_thenCallsGetFilterValueConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    RestrictionFactory delegate = mock(RestrictionFactory.class);
    when(delegate.getRestriction(Mockito.<String>any(), Mockito.<String>any())).thenReturn(restriction);

    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();
    skuRestrictionFactoryImpl.setDelegate(delegate);

    // Act
    Restriction actualRestriction = skuRestrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(restriction).getFilterValueConverter();
    verify(delegate).getRestriction(eq("Type"), eq("42"));
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}.
   * <ul>
   *   <li>Then return FilterValueConverter is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  public void testGetRestriction_thenReturnFilterValueConverterIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RestrictionFactory delegate = mock(RestrictionFactory.class);
    when(delegate.getRestriction(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new Restriction());

    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();
    skuRestrictionFactoryImpl.setDelegate(delegate);

    // Act
    Restriction actualRestriction = skuRestrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(delegate).getRestriction(eq("Type"), eq("42"));
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualRestriction.getFilterValueConverter());
  }

  /**
   * Test
   * {@link SkuRestrictionFactoryImpl#buildCompositePredicate(CriteriaBuilder, Path, Path, Predicate, Predicate)}.
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#buildCompositePredicate(CriteriaBuilder, Path, Path, Predicate, Predicate)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildCompositePredicate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7262 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuRestrictionFactoryImpl skuRestrictionFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl2 = new SkuRestrictionFactoryImpl();
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
    CollectionAttributeJoin.TreatedCollectionAttributeJoin targetPropertyPath = new CollectionAttributeJoin.TreatedCollectionAttributeJoin(
        original, treatAsType2);

    CriteriaBuilderImpl criteriaBuilder2 = new CriteriaBuilderImpl(
        new SessionFactoryImpl(null, null, mock(QueryPlanCache.QueryPlanCreator.class)));
    Class<Object> javaType2 = Object.class;
    Class<Object> treatAsType3 = Object.class;
    CollectionAttributeJoin original2 = new CollectionAttributeJoin(criteriaBuilder2, javaType2,
        new ListAttributeJoin.TreatedListAttributeJoin(null, treatAsType3), null, JoinType.INNER);

    Class<Object> treatAsType4 = Object.class;
    CollectionAttributeJoin.TreatedCollectionAttributeJoin productPath = new CollectionAttributeJoin.TreatedCollectionAttributeJoin(
        original2, treatAsType4);

    CriteriaBuilderImpl criteriaBuilder3 = new CriteriaBuilderImpl(null);
    Class<Boolean> javaType3 = Boolean.class;
    NegatedPredicateWrapper propertyExpression = new NegatedPredicateWrapper(
        new BooleanExpressionPredicate(criteriaBuilder3, new CriteriaSubqueryImpl<>(null, javaType3, null)));
    CriteriaBuilderImpl criteriaBuilder4 = new CriteriaBuilderImpl(null);
    Class<Boolean> javaType4 = Boolean.class;

    // Act
    skuRestrictionFactoryImpl2.buildCompositePredicate(builder, targetPropertyPath, productPath, propertyExpression,
        new NegatedPredicateWrapper(
            new BooleanExpressionPredicate(criteriaBuilder4, new CriteriaSubqueryImpl<>(null, javaType4, null))));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuRestrictionFactoryImpl#setDelegate(RestrictionFactory)}
   *   <li>{@link SkuRestrictionFactoryImpl#getDelegate()}
   *   <li>{@link SkuRestrictionFactoryImpl#getSkuPropertyPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();
    RestrictionFactory delegate = mock(RestrictionFactory.class);

    // Act
    skuRestrictionFactoryImpl.setDelegate(delegate);
    RestrictionFactory actualDelegate = skuRestrictionFactoryImpl.getDelegate();
    skuRestrictionFactoryImpl.getSkuPropertyPrefix();

    // Assert that nothing has changed
    assertSame(delegate, actualDelegate);
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  public void testSetSkuPropertyPrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix("Sku Property Prefix");

    // Assert
    assertEquals("Sku Property Prefix.", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  public void testSetSkuPropertyPrefix2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix("");

    // Assert
    assertEquals("", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  public void testSetSkuPropertyPrefix3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();
    skuRestrictionFactoryImpl.setDelegate(mock(RestrictionFactory.class));

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix("Sku Property Prefix");

    // Assert
    assertEquals("Sku Property Prefix.", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetSkuPropertyPrefix4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7514 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuRestrictionFactoryImpl skuRestrictionFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuRestrictionFactoryImpl()).setSkuPropertyPrefix("Sku Property Prefix");
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   * <ul>
   *   <li>Then {@link SkuRestrictionFactoryImpl} (default constructor)
   * SkuPropertyPrefix is {@code .}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  public void testSetSkuPropertyPrefix_thenSkuRestrictionFactoryImplSkuPropertyPrefixIsDot() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix(".");

    // Assert
    assertEquals(".", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   * <ul>
   *   <li>Then {@link SkuRestrictionFactoryImpl} (default constructor)
   * SkuPropertyPrefix is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  public void testSetSkuPropertyPrefix_thenSkuRestrictionFactoryImplSkuPropertyPrefixIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();

    // Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix(null);

    // Assert
    assertNull(skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }
}
