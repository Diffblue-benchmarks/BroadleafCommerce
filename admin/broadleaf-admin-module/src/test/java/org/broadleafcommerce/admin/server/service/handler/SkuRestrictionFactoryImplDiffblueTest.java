/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class SkuRestrictionFactoryImplDiffblueTest {
  @Mock private RestrictionFactory restrictionFactory;

  @InjectMocks private SkuRestrictionFactoryImpl skuRestrictionFactoryImpl;

  /**
   * Test {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Restriction#getFilterValueConverter()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction SkuRestrictionFactoryImpl.getRestriction(String, String)"})
  public void testGetRestriction_thenCallsGetFilterValueConverter() {
    // Arrange
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    when(restrictionFactory.getRestriction(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(restriction);

    // Act
    Restriction actualRestriction = skuRestrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(restriction).getFilterValueConverter();
    verify(restrictionFactory).getRestriction("Type", "42");
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}.
   *
   * <ul>
   *   <li>Then return FilterValueConverter is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#getRestriction(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Restriction SkuRestrictionFactoryImpl.getRestriction(String, String)"})
  public void testGetRestriction_thenReturnFilterValueConverterIsNull() {
    // Arrange
    when(restrictionFactory.getRestriction(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new Restriction());

    // Act
    Restriction actualRestriction = skuRestrictionFactoryImpl.getRestriction("Type", "42");

    // Assert
    verify(restrictionFactory).getRestriction("Type", "42");
    FieldPathBuilder fieldPathBuilder = actualRestriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualRestriction.getFilterValueConverter());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuRestrictionFactoryImpl#setDelegate(RestrictionFactory)}
   *   <li>{@link SkuRestrictionFactoryImpl#getDelegate()}
   *   <li>{@link SkuRestrictionFactoryImpl#getSkuPropertyPrefix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestrictionFactory SkuRestrictionFactoryImpl.getDelegate()",
    "String SkuRestrictionFactoryImpl.getSkuPropertyPrefix()",
    "void SkuRestrictionFactoryImpl.setDelegate(RestrictionFactory)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SkuRestrictionFactoryImpl skuRestrictionFactoryImpl = new SkuRestrictionFactoryImpl();
    RestrictionFactory delegate = mock(RestrictionFactory.class);

    // Act
    skuRestrictionFactoryImpl.setDelegate(delegate);
    RestrictionFactory actualDelegate = skuRestrictionFactoryImpl.getDelegate();

    // Assert
    assertNull(skuRestrictionFactoryImpl.getSkuPropertyPrefix());
    assertSame(delegate, actualDelegate);
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuRestrictionFactoryImpl.setSkuPropertyPrefix(String)"})
  public void testSetSkuPropertyPrefix() {
    // Arrange and Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix("Sku Property Prefix");

    // Assert
    assertEquals("Sku Property Prefix.", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuRestrictionFactoryImpl.setSkuPropertyPrefix(String)"})
  public void testSetSkuPropertyPrefix2() {
    // Arrange and Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix("");

    // Assert
    assertEquals("", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuRestrictionFactoryImpl} SkuPropertyPrefix is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuRestrictionFactoryImpl.setSkuPropertyPrefix(String)"})
  public void testSetSkuPropertyPrefix_thenSkuRestrictionFactoryImplSkuPropertyPrefixIsDot() {
    // Arrange and Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix(".");

    // Assert
    assertEquals(".", skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }

  /**
   * Test {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuRestrictionFactoryImpl} SkuPropertyPrefix is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuRestrictionFactoryImpl#setSkuPropertyPrefix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuRestrictionFactoryImpl.setSkuPropertyPrefix(String)"})
  public void testSetSkuPropertyPrefix_thenSkuRestrictionFactoryImplSkuPropertyPrefixIsNull() {
    // Arrange and Act
    skuRestrictionFactoryImpl.setSkuPropertyPrefix(null);

    // Assert that nothing has changed
    assertNull(skuRestrictionFactoryImpl.getSkuPropertyPrefix());
  }
}
