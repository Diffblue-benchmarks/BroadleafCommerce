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
   * Test {@link SystemPropertiesServiceImpl#buildKey(String)} with
   * {@code propertyName}.
   * <p>
   * Method under test: {@link SystemPropertiesServiceImpl#buildKey(String)}
   */
  @Test
  public void testBuildKeyWithPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Property Name", (new SystemPropertiesServiceImpl()).buildKey("Property Name"));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)} with
   * {@code propertyName}, {@code siteId}, {@code forceEnvPrefix}.
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)}
   */
  @Test
  public void testBuildKeyWithPropertyNameSiteIdForceEnvPrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ORIGIN_FROM_ENV-1-Property Name",
        (new SystemPropertiesServiceImpl()).buildKey("Property Name", 1L, true));
    assertEquals("ORIGIN_FROM_ENV-Property Name",
        (new SystemPropertiesServiceImpl()).buildKey("Property Name", null, true));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)} with
   * {@code propertyName}, {@code siteId}, {@code forceEnvPrefix}.
   * <ul>
   *   <li>Then return {@code 1-Property Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(String, Long, boolean)}
   */
  @Test
  public void testBuildKeyWithPropertyNameSiteIdForceEnvPrefix_thenReturn1PropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1-Property Name", (new SystemPropertiesServiceImpl()).buildKey("Property Name", 1L, false));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long)} with
   * {@code propertyName}, {@code siteId}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertiesServiceImpl#buildKey(String, Long)}
   */
  @Test
  public void testBuildKeyWithPropertyNameSiteId_whenNull_thenReturnPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Property Name", (new SystemPropertiesServiceImpl()).buildKey("Property Name", null));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(String, Long)} with
   * {@code propertyName}, {@code siteId}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 1-Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertiesServiceImpl#buildKey(String, Long)}
   */
  @Test
  public void testBuildKeyWithPropertyNameSiteId_whenOne_thenReturn1PropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1-Property Name", (new SystemPropertiesServiceImpl()).buildKey("Property Name", 1L));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   * with {@code systemProperty}, {@code forceEnvPrefix}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   */
  @Test
  public void testBuildKeyWithSystemPropertyForceEnvPrefix_givenName_whenFalse_thenReturnName() {
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
   * Test {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   * with {@code systemProperty}, {@code forceEnvPrefix}.
   * <ul>
   *   <li>Then return {@code ORIGIN_FROM_ENV-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   */
  @Test
  public void testBuildKeyWithSystemPropertyForceEnvPrefix_thenReturnOriginFromEnvName() {
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
   * Test {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   * with {@code systemProperty}, {@code forceEnvPrefix}.
   * <ul>
   *   <li>Then return {@code ORIGIN_FROM_ENV-null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty, boolean)}
   */
  @Test
  public void testBuildKeyWithSystemPropertyForceEnvPrefix_thenReturnOriginFromEnvNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertEquals("ORIGIN_FROM_ENV-null", systemPropertiesServiceImpl.buildKey(new NullSystemProperty(), true));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#buildKey(SystemProperty)} with
   * {@code systemProperty}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty)}
   */
  @Test
  public void testBuildKeyWithSystemProperty_givenName_thenReturnName() {
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
   * Test {@link SystemPropertiesServiceImpl#buildKey(SystemProperty)} with
   * {@code systemProperty}.
   * <ul>
   *   <li>When {@link NullSystemProperty} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#buildKey(SystemProperty)}
   */
  @Test
  public void testBuildKeyWithSystemProperty_whenNullSystemProperty_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertNull(systemPropertiesServiceImpl.buildKey(new NullSystemProperty()));
  }

  /**
   * Test {@link SystemPropertiesServiceImpl#getCacheName()}.
   * <p>
   * Method under test: {@link SystemPropertiesServiceImpl#getCacheName()}
   */
  @Test
  public void testGetCacheName() {
    // Arrange, Act and Assert
    assertEquals("blSystemPropertyElements", (new SystemPropertiesServiceImpl()).getCacheName());
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(systemPropertiesServiceImpl.isValueValidForType("42", new SystemPropertyFieldType("TRUE", "TRUE")));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(
        systemPropertiesServiceImpl.isValueValidForType("42", new SystemPropertyFieldType("BOOLEAN_TYPE", "TRUE")));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#BOOLEAN_TYPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenBoolean_type_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.BOOLEAN_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#DOUBLE_TYPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenDouble_type_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("TRUE", SystemPropertyFieldType.DOUBLE_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#DOUBLE_TYPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenDouble_type_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.DOUBLE_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@code FALSE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenFalse_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("FALSE", SystemPropertyFieldType.BOOLEAN_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#INT_TYPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenInt_type_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("TRUE", SystemPropertyFieldType.INT_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#INT_TYPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenInt_type_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.INT_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#LONG_TYPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenLong_type_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("TRUE", SystemPropertyFieldType.LONG_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#LONG_TYPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenLong_type_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.LONG_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType(null, SystemPropertyFieldType.BOOLEAN_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#STRING_TYPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenString_type_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("42", SystemPropertyFieldType.STRING_TYPE));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType#SystemPropertyFieldType()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenSystemPropertyFieldType_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesServiceImpl systemPropertiesServiceImpl = new SystemPropertiesServiceImpl();

    // Act and Assert
    assertFalse(systemPropertiesServiceImpl.isValueValidForType("42", new SystemPropertyFieldType()));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@link SystemPropertyFieldType}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenSystemPropertyFieldType_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SystemPropertiesServiceImpl()).isValueValidForType("42", mock(SystemPropertyFieldType.class)));
  }

  /**
   * Test
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}.
   * <ul>
   *   <li>When {@code TRUE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertiesServiceImpl#isValueValidForType(String, SystemPropertyFieldType)}
   */
  @Test
  public void testIsValueValidForType_whenTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SystemPropertiesServiceImpl()).isValueValidForType("TRUE", SystemPropertyFieldType.BOOLEAN_TYPE));
  }
}
