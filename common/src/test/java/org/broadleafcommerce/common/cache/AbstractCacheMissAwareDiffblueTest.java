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
package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.config.dao.SystemPropertiesDaoImpl;
import org.junit.Test;

public class AbstractCacheMissAwareDiffblueTest {
  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  public void testBuildKey_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SystemPropertiesDaoImpl()).buildKey());
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>Then return {@code ThreadLocalManager.notify.orphans_true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  public void testBuildKey_thenReturnThreadLocalManagerNotifyOrphansTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesDaoImpl systemPropertiesDaoImpl = new SystemPropertiesDaoImpl();

    // Act and Assert
    assertEquals("ThreadLocalManager.notify.orphans_true",
        systemPropertiesDaoImpl.buildKey("ThreadLocalManager.notify.orphans", Boolean.TRUE.toString()));
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@link Boolean#TRUE} toString.</li>
   *   <li>Then return {@code 42_true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  public void testBuildKey_when42AndTrueToString_thenReturn42True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertiesDaoImpl systemPropertiesDaoImpl = new SystemPropertiesDaoImpl();

    // Act and Assert
    assertEquals("42_true", systemPropertiesDaoImpl.buildKey("42", Boolean.TRUE.toString()));
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  public void testBuildKey_whenEmptyString_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SystemPropertiesDaoImpl()).buildKey(""));
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  public void testBuildKey_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SystemPropertiesDaoImpl()).buildKey(null));
  }

  /**
   * Test {@link AbstractCacheMissAware#buildKey(String[])}.
   * <ul>
   *   <li>When {@code Params}.</li>
   *   <li>Then return {@code Params}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCacheMissAware#buildKey(String[])}
   */
  @Test
  public void testBuildKey_whenParams_thenReturnParams() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Params", (new SystemPropertiesDaoImpl()).buildKey("Params"));
  }
}
