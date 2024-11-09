/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class RestrictionFactoryImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RestrictionFactoryImpl#setRestrictions(Map)}
   *   <li>{@link RestrictionFactoryImpl#getRestrictions()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    HashMap<String, Restriction> restrictions = new HashMap<>();

    // Act
    restrictionFactoryImpl.setRestrictions(restrictions);
    Map<String, Restriction> actualRestrictions = restrictionFactoryImpl.getRestrictions();

    // Assert that nothing has changed
    assertTrue(actualRestrictions.isEmpty());
    assertSame(restrictions, actualRestrictions);
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   * <p>
   * Method under test:
   * {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  public void testGetRestriction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, Restriction> restrictions = new HashMap<>();
    restrictions.put("42", new Restriction());
    restrictions.computeIfPresent("foo", mock(BiFunction.class));

    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    restrictionFactoryImpl.setRestrictions(restrictions);

    // Act
    Restriction actualRestriction = restrictionFactoryImpl.getRestriction("42", "42");

    // Assert
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertTrue(fieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualRestriction.getFilterValueConverter());
    assertNull(actualRestriction.getPredicateProvider());
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   * <ul>
   *   <li>Given {@link Restriction} {@link Restriction#clone()} return
   * {@link Restriction} (default constructor).</li>
   *   <li>Then return {@link Restriction} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  public void testGetRestriction_givenRestrictionCloneReturnRestriction_thenReturnRestriction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = mock(Restriction.class);
    Restriction restriction2 = new Restriction();
    when(restriction.clone()).thenReturn(restriction2);

    HashMap<String, Restriction> restrictions = new HashMap<>();
    restrictions.put("42", restriction);
    restrictions.computeIfPresent("foo", mock(BiFunction.class));

    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    restrictionFactoryImpl.setRestrictions(restrictions);

    // Act
    Restriction actualRestriction = restrictionFactoryImpl.getRestriction("42", "42");

    // Assert
    verify(restriction).clone();
    assertSame(restriction2, actualRestriction);
  }

  /**
   * Test {@link RestrictionFactoryImpl#getRestriction(String, String)}.
   * <ul>
   *   <li>Then calls
   * {@link Restriction#setFieldPathBuilder(FieldPathBuilder)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  public void testGetRestriction_thenCallsSetFieldPathBuilder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Restriction restriction = mock(Restriction.class);
    doNothing().when(restriction).setFieldPathBuilder(Mockito.<FieldPathBuilder>any());
    Restriction restriction2 = mock(Restriction.class);
    when(restriction2.clone()).thenReturn(restriction);

    HashMap<String, Restriction> restrictions = new HashMap<>();
    restrictions.put("42", restriction2);
    restrictions.computeIfPresent("foo", mock(BiFunction.class));

    RestrictionFactoryImpl restrictionFactoryImpl = new RestrictionFactoryImpl();
    restrictionFactoryImpl.setRestrictions(restrictions);

    // Act
    restrictionFactoryImpl.getRestriction("42", "42");

    // Assert
    verify(restriction2).clone();
    verify(restriction).setFieldPathBuilder(isA(FieldPathBuilder.class));
  }
}
