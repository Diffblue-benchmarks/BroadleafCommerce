/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.config.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.config.domain.NullSystemProperty;
import org.broadleafcommerce.common.config.domain.SystemProperty;
import org.junit.Test;

public class SystemPropertiesDaoImplDiffblueTest {
  /**
   * Test {@link SystemPropertiesDaoImpl#getLogger()}.
   * <p>
   * Method under test: {@link SystemPropertiesDaoImpl#getLogger()}
   */
  @Test
  public void testGetLogger() {
    // Arrange
    SystemPropertiesDaoImpl systemPropertiesDaoImpl = new SystemPropertiesDaoImpl();

    // Act and Assert
    assertSame(systemPropertiesDaoImpl.LOG, systemPropertiesDaoImpl.getLogger());
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#getSite()}.
   * <p>
   * Method under test: {@link SystemPropertiesDaoImpl#getSite()}
   */
  @Test
  public void testGetSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SystemPropertiesDaoImpl()).getSite());
  }

  /**
   * Test {@link SystemPropertiesDaoImpl#getNullObject(Class)}.
   * <p>
   * Method under test: {@link SystemPropertiesDaoImpl#getNullObject(Class)}
   */
  @Test
  public void testGetNullObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesDaoImpl systemPropertiesDaoImpl = new SystemPropertiesDaoImpl();
    Class<SystemProperty> responseClass = SystemProperty.class;

    // Act
    SystemProperty actualNullObject = systemPropertiesDaoImpl.getNullObject(responseClass);

    // Assert
    assertTrue(actualNullObject instanceof NullSystemProperty);
    assertNull(actualNullObject.getOverrideGeneratedPropertyName());
    assertNull(actualNullObject.getId());
    assertNull(actualNullObject.getFriendlyGroup());
    assertNull(actualNullObject.getFriendlyName());
    assertNull(actualNullObject.getFriendlyTab());
    assertNull(actualNullObject.getName());
    assertNull(actualNullObject.getValue());
    assertNull(actualNullObject.getPropertyType());
  }
}
