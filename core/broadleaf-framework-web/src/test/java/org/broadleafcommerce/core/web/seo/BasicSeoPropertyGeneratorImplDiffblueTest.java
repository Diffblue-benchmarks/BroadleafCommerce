/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.seo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class BasicSeoPropertyGeneratorImplDiffblueTest {
  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  void testFilterForSeoProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(new HashMap<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  void testFilterForSeoProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("foo", "foo");

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  void testFilterForSeoProperties3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("title", mock(BiFunction.class));
    properties.put("foo", "foo");

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  void testFilterForSeoProperties4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("title", "foo");

    // Act
    Map<String, String> actualFilterForSeoPropertiesResult = basicSeoPropertyGeneratorImpl
        .filterForSeoProperties(properties);

    // Assert
    assertEquals(1, actualFilterForSeoPropertiesResult.size());
    assertEquals("foo", actualFilterForSeoPropertiesResult.get("title"));
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  void testFilterForSeoProperties5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("metaDescription", "foo");

    // Act
    Map<String, String> actualFilterForSeoPropertiesResult = basicSeoPropertyGeneratorImpl
        .filterForSeoProperties(properties);

    // Assert
    assertEquals(1, actualFilterForSeoPropertiesResult.size());
    assertEquals("foo", actualFilterForSeoPropertiesResult.get("metaDescription"));
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  void testAddDefaultTitle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    HashMap<String, String> properties = new HashMap<>();

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Dr", properties.get("title"));
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  void testAddDefaultTitle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("title", "Properties");

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertEquals("Properties", properties.get("title"));
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  void testAddDefaultTitle3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("title", mock(BiFunction.class));

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Dr", properties.get("title"));
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  void testAddDefaultDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();
    HashMap<String, String> properties = new HashMap<>();

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Default Description", properties.get("metaDescription"));
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  void testAddDefaultDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("metaDescription", "Properties");

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertEquals("Properties", properties.get("metaDescription"));
  }

  /**
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  void testAddDefaultDescription3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("metaDescription", mock(BiFunction.class));

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Default Description", properties.get("metaDescription"));
  }
}
