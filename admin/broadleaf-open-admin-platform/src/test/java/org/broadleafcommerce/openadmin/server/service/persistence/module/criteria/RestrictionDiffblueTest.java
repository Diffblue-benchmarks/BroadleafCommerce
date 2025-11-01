/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.junit.Test;

public class RestrictionDiffblueTest {
  /**
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
   * Method under test: {@link Restriction#withFieldPathBuilder(FieldPathBuilder)}
   */
  @Test
  public void testWithFieldPathBuilder() {
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
   * Method under test: {@link Restriction#clone()}
   */
  @Test
  public void testClone() {
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
   * Method under test: {@link Restriction#clone()}
   */
  @Test
  public void testClone2() {
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
}
