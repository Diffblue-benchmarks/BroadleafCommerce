/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.seo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicSeoPropertyGeneratorImplDiffblueTest {
  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given BiFunction")
  void testFilterForSeoProperties_givenBiFunction() {
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
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return Empty")
  void testFilterForSeoProperties_givenFoo_whenHashMapFooIsFoo_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("foo", "foo");

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code metaDescription}.</li>
   *   <li>Then return {@code metaDescription} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'metaDescription'; then return 'metaDescription' is 'foo'")
  void testFilterForSeoProperties_givenMetaDescription_thenReturnMetaDescriptionIsFoo() {
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
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code title}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code title} is {@code foo}.</li>
   *   <li>Then return {@code title} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'title'; when HashMap() 'title' is 'foo'; then return 'title' is 'foo'")
  void testFilterForSeoProperties_givenTitle_whenHashMapTitleIsFoo_thenReturnTitleIsFoo() {
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
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); when HashMap(); then return Empty")
  void testFilterForSeoProperties_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl = new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String); given BiFunction")
  void testAddDefaultTitle_givenBiFunction() {
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
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <ul>
   *   <li>Given {@code Properties}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code title} is {@code Properties}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String); given 'Properties'; then HashMap() 'title' is 'Properties'")
  void testAddDefaultTitle_givenProperties_thenHashMapTitleIsProperties() {
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
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code title} is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String); when HashMap(); then HashMap() 'title' is 'Dr'")
  void testAddDefaultTitle_whenHashMap_thenHashMapTitleIsDr() {
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
   * Test
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String); given BiFunction")
  void testAddDefaultDescription_givenBiFunction() {
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

  /**
   * Test
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <ul>
   *   <li>Given {@code Properties}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code metaDescription} is
   * {@code Properties}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String); given 'Properties'; then HashMap() 'metaDescription' is 'Properties'")
  void testAddDefaultDescription_givenProperties_thenHashMapMetaDescriptionIsProperties() {
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
   * Test
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String); when HashMap()")
  void testAddDefaultDescription_whenHashMap() {
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
}
