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
package org.broadleafcommerce.core.web.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class ProcessorUtilsDiffblueTest {
  /**
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  void testGetUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", ProcessorUtils.getUrl("https://example.org/example", new HashMap<>()));
    assertThrows(IllegalArgumentException.class, () -> ProcessorUtils.getUrl("?", null));
    assertEquals("https://example.org/example", ProcessorUtils.getUrl("https://example.org/example", null));
  }

  /**
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  void testGetUrl2() {
    // Arrange
    HashMap<String, String[]> parameters = new HashMap<>();
    parameters.put("?", new String[]{"?"});

    // Act and Assert
    assertEquals("https://example.org/example?%3F=%3F",
        ProcessorUtils.getUrl("https://example.org/example", parameters));
  }

  /**
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  void testGetUrl3() {
    // Arrange
    HashMap<String, String[]> parameters = new HashMap<>();
    parameters.computeIfPresent("?", mock(BiFunction.class));
    parameters.put("?", new String[]{"?"});

    // Act and Assert
    assertEquals("https://example.org/example?%3F=%3F",
        ProcessorUtils.getUrl("https://example.org/example", parameters));
  }

  /**
   * Method under test: {@link ProcessorUtils#getUrl(String, Map)}
   */
  @Test
  void testGetUrl4() {
    // Arrange
    HashMap<String, String[]> parameters = new HashMap<>();
    parameters.put("?", new String[]{});

    // Act and Assert
    assertEquals("https://example.org/example", ProcessorUtils.getUrl("https://example.org/example", parameters));
  }
}
