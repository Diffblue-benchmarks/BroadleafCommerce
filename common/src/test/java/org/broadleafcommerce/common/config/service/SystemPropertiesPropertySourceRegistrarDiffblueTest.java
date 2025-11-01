/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.config.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;

public class SystemPropertiesPropertySourceRegistrarDiffblueTest {
  /**
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource#getProperty(String)}
   */
  @Test
  public void testSystemPropertyPropertySourceGetProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl source = mock(SystemPropertiesServiceImpl.class);
    when(source.resolveSystemProperty(Mockito.<String>any())).thenReturn("Resolve System Property");

    // Act
    Object actualProperty = (new SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource("Name", source))
        .getProperty("Name");

    // Assert
    verify(source).resolveSystemProperty(eq("Name"));
    assertEquals("Resolve System Property", actualProperty);
  }

  /**
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource#SystemPropertyPropertySource(String, SystemPropertiesService)}
   */
  @Test
  public void testSystemPropertyPropertySourceNewSystemPropertyPropertySource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl source = new SystemPropertiesServiceImpl();

    // Act
    SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource actualSystemPropertyPropertySource = new SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource(
        "Name", source);

    // Assert
    assertEquals("Name", actualSystemPropertyPropertySource.getName());
    assertSame(source, actualSystemPropertyPropertySource.getSource());
  }

  /**
   * Method under test:
   * {@link SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource#SystemPropertyPropertySource(String, SystemPropertiesService)}
   */
  @Test
  public void testSystemPropertyPropertySourceNewSystemPropertyPropertySource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl source = mock(SystemPropertiesServiceImpl.class);

    // Act
    SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource actualSystemPropertyPropertySource = new SystemPropertiesPropertySourceRegistrar.SystemPropertyPropertySource(
        "Name", source);

    // Assert
    assertEquals("Name", actualSystemPropertyPropertySource.getName());
    assertSame(source, actualSystemPropertyPropertySource.getSource());
  }
}
