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
package org.broadleafcommerce.core.web.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProcessorUtilsDiffblueTest {
  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code ?} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @DisplayName("Test getUrl(String, Map); given BiFunction; when HashMap() computeIfPresent '?' and BiFunction")
  void testGetUrl_givenBiFunction_whenHashMapComputeIfPresentQuestionMarkAndBiFunction() {
    // Arrange
    HashMap<String, String[]> parameters = new HashMap<>();
    parameters.computeIfPresent("?", mock(BiFunction.class));
    parameters.put("?", new String[]{"?"});

    // Act and Assert
    assertEquals("https://example.org/example?%3F=%3F",
        ProcessorUtils.getUrl("https://example.org/example", parameters));
  }

  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code ?} is empty array of
   * {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @DisplayName("Test getUrl(String, Map); given empty array of String; when HashMap() '?' is empty array of String")
  void testGetUrl_givenEmptyArrayOfString_whenHashMapQuestionMarkIsEmptyArrayOfString() {
    // Arrange
    HashMap<String, String[]> parameters = new HashMap<>();
    parameters.put("?", new String[]{});

    // Act and Assert
    assertEquals("https://example.org/example", ProcessorUtils.getUrl("https://example.org/example", parameters));
  }

  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example?%3F=%3F}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @DisplayName("Test getUrl(String, Map); then return 'https://example.org/example?%3F=%3F'")
  void testGetUrl_thenReturnHttpsExampleOrgExample3f3f() {
    // Arrange
    HashMap<String, String[]> parameters = new HashMap<>();
    parameters.put("?", new String[]{"?"});

    // Act and Assert
    assertEquals("https://example.org/example?%3F=%3F",
        ProcessorUtils.getUrl("https://example.org/example", parameters));
  }

  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @DisplayName("Test getUrl(String, Map); when HashMap(); then return 'https://example.org/example'")
  void testGetUrl_whenHashMap_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", ProcessorUtils.getUrl("https://example.org/example", new HashMap<>()));
  }

  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @DisplayName("Test getUrl(String, Map); when 'null'; then return 'https://example.org/example'")
  void testGetUrl_whenNull_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", ProcessorUtils.getUrl("https://example.org/example", null));
  }

  /**
   * Test {@link ProcessorUtils#getUrl(String, Map)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  @DisplayName("Test getUrl(String, Map); when '?'; then throw IllegalArgumentException")
  void testGetUrl_whenQuestionMark_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProcessorUtils.getUrl("?", null));
  }
}
