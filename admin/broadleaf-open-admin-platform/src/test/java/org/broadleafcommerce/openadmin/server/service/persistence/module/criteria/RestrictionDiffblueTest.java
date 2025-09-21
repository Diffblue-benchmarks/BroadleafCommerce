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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Restriction.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class RestrictionDiffblueTest {
  @Autowired private Restriction restriction;

  /**
   * Test {@link Restriction#withPredicateProvider(PredicateProvider)}.
   *
   * <p>Method under test: {@link Restriction#withPredicateProvider(PredicateProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction Restriction.withPredicateProvider(PredicateProvider)"})
  public void testWithPredicateProvider() {
    // Arrange
    PredicateProvider predicateProvider = mock(PredicateProvider.class);

    // Act
    Restriction actualWithPredicateProviderResult =
        restriction.withPredicateProvider(predicateProvider);

    // Assert
    assertSame(restriction, actualWithPredicateProviderResult);
    assertSame(predicateProvider, restriction.getPredicateProvider());
  }

  /**
   * Test {@link Restriction#withFilterValueConverter(FilterValueConverter)}.
   *
   * <p>Method under test: {@link Restriction#withFilterValueConverter(FilterValueConverter)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction Restriction.withFilterValueConverter(FilterValueConverter)"})
  public void testWithFilterValueConverter() {
    // Arrange
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);

    // Act
    Restriction actualWithFilterValueConverterResult =
        restriction.withFilterValueConverter(filterValueConverter);

    // Assert
    assertSame(restriction, actualWithFilterValueConverterResult);
    assertSame(filterValueConverter, restriction.getFilterValueConverter());
  }

  /**
   * Test {@link Restriction#withFieldPathBuilder(FieldPathBuilder)}.
   *
   * <ul>
   *   <li>Then {@link Restriction} FieldPathBuilder is {@link FieldPathBuilder} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link Restriction#withFieldPathBuilder(FieldPathBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction Restriction.withFieldPathBuilder(FieldPathBuilder)"})
  public void testWithFieldPathBuilder_thenRestrictionFieldPathBuilderIsFieldPathBuilder() {
    // Arrange
    FieldPathBuilder fieldPathBuilder = new FieldPathBuilder();
    CriteriaBuilderImpl criteriaBuilder = new CriteriaBuilderImpl(null);
    Class<Object> returnType = Object.class;
    fieldPathBuilder.setCriteria(new CriteriaQueryImpl(criteriaBuilder, returnType));
    fieldPathBuilder.setRestrictions(new ArrayList<>());

    // Act
    Restriction actualWithFieldPathBuilderResult =
        restriction.withFieldPathBuilder(fieldPathBuilder);

    // Assert
    assertSame(fieldPathBuilder, restriction.getFieldPathBuilder());
    assertSame(restriction, actualWithFieldPathBuilderResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Restriction#setFilterValueConverter(FilterValueConverter)}
   *   <li>{@link Restriction#setPredicateProvider(PredicateProvider)}
   *   <li>{@link Restriction#getFieldPathBuilder()}
   *   <li>{@link Restriction#getFilterValueConverter()}
   *   <li>{@link Restriction#getPredicateProvider()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldPathBuilder Restriction.getFieldPathBuilder()",
    "FilterValueConverter Restriction.getFilterValueConverter()",
    "PredicateProvider Restriction.getPredicateProvider()",
    "void Restriction.setFieldPathBuilder(FieldPathBuilder)",
    "void Restriction.setFilterValueConverter(FilterValueConverter)",
    "void Restriction.setPredicateProvider(PredicateProvider)"
  })
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

    // Assert
    assertTrue(actualFieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(actualFieldPathBuilder.getRestrictions());
    assertNull(actualFieldPathBuilder.getCriteria());
    assertSame(filterValueConverter, actualFilterValueConverter);
    assertSame(predicateProvider, restriction.getPredicateProvider());
  }

  /**
   * Test {@link Restriction#clone()}.
   *
   * <p>Method under test: {@link Restriction#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction Restriction.clone()"})
  public void testClone() {
    // Arrange and Act
    Restriction actualCloneResult = restriction.clone();

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
   *
   * <p>Method under test: default or parameterless constructor of {@link Restriction}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Restriction.<init>()"})
  public void testNewRestriction() {
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
