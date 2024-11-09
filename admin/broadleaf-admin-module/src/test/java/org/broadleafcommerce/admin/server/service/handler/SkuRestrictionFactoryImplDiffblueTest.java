/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.junit.Test;
import org.mockito.Mockito;

public class SkuRestrictionFactoryImplDiffblueTest {
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
