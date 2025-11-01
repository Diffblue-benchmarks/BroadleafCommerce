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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.config.domain.NullSystemProperty;
import org.broadleafcommerce.common.config.domain.SystemProperty;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.junit.Test;

public class SystemPropertiesServiceImplDiffblueTest {
  /**
   * Method under test: {@link SystemPropertiesServiceImpl#buildKey(String)}
   */
  @Test
  public void testBuildKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Property Name", (new SystemPropertiesServiceImpl()).buildKey("Property Name"));
    assertEquals("1-Property Name", (new SystemPropertiesServiceImpl()).buildKey("Property Name", 1L));
    assertEquals("Property Name", (new SystemPropertiesServiceImpl()).buildKey("Property Name", null));
    assertEquals("ORIGIN_FROM_ENV-1-Property Name",
        (new SystemPropertiesServiceImpl()).buildKey("Property Name", 1L, true));
    assertEquals("ORIGIN_FROM_ENV-Property Name",
        (new SystemPropertiesServiceImpl()).buildKey("Property Name", null, true));
    assertEquals("1-Property Name", (new SystemPropertiesServiceImpl()).buildKey("Property Name", 1L, false));
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty)}
   */
  @Test
  public void testBuildKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertNull(systemPropertiesServiceImpl.buildKey(new NullSystemProperty()));
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty)}
   */
  @Test
  public void testBuildKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();
    SystemProperty systemProperty = mock(SystemProperty.class);
    when(systemProperty.getName()).thenReturn("Name");

    // Act
    String actualBuildKeyResult = systemPropertiesServiceImpl.buildKey(systemProperty);

    // Assert
    verify(systemProperty).getName();
    assertEquals("Name", actualBuildKeyResult);
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   */
  @Test
  public void testBuildKey4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertEquals("ORIGIN_FROM_ENV-null", systemPropertiesServiceImpl.buildKey(new NullSystemProperty(), true));
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   */
  @Test
  public void testBuildKey5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();
    SystemProperty systemProperty = mock(SystemProperty.class);
    when(systemProperty.getName()).thenReturn("Name");

    // Act
    String actualBuildKeyResult = systemPropertiesServiceImpl.buildKey(systemProperty, true);

    // Assert
    verify(systemProperty).getName();
    assertEquals("ORIGIN_FROM_ENV-Name", actualBuildKeyResult);
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   */
  @Test
  public void testBuildKey6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();
    SystemProperty systemProperty = mock(SystemProperty.class);
    when(systemProperty.getName()).thenReturn("Name");

    // Act
    String actualBuildKeyResult = systemPropertiesServiceImpl.buildKey(systemProperty, false);

    // Assert
    verify(systemProperty).getName();
    assertEquals("Name", actualBuildKeyResult);
  }

  /**
   * Method under test: {@link SystemPropertiesServiceImpl#getCacheName()}
   */
  @Test
  public void testGetCacheName() {
    // Arrange, Act and Assert
    assertEquals("blSystemPropertyElements", (new SystemPropertiesServiceImpl()).getCacheName());
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.BOOLEAN_TYPE));
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("TRUE", SystemPropertyFieldType.BOOLEAN_TYPE));
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("FALSE", SystemPropertyFieldType.BOOLEAN_TYPE));
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType(null, SystemPropertyFieldType.BOOLEAN_TYPE));
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.DOUBLE_TYPE));
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.INT_TYPE));
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.LONG_TYPE));
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.STRING_TYPE));
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("42", mock(SystemPropertyFieldType.class)));
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("TRUE", SystemPropertyFieldType.DOUBLE_TYPE));
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("TRUE", SystemPropertyFieldType.INT_TYPE));
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("TRUE", SystemPropertyFieldType.LONG_TYPE));
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(systemPropertiesServiceImpl.isValueValidForType("42", new SystemPropertyFieldType("TRUE", "TRUE")));
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(systemPropertiesServiceImpl.isValueValidForType("42", new SystemPropertyFieldType()));
  }

  /**
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(
        systemPropertiesServiceImpl.isValueValidForType("42", new SystemPropertyFieldType("BOOLEAN_TYPE", "TRUE")));
  }
}
