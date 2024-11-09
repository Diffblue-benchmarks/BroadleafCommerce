/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;

public class BroadleafEnumerationUtilityDiffblueTest {
  /**
   * Test
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}.
   * <ul>
   *   <li>When {@code Broadleaf Enumeration Class}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}
   */
  @Test
  public void testGetEnumerationValues_whenBroadleafEnumerationClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafEnumerationUtility
        .getEnumerationValues("Broadleaf Enumeration Class", new DynamicEntityDaoImpl()));
  }

  /**
   * Test
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}.
   * <ul>
   *   <li>When {@code java.lang.Comparable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getEnumerationValues(String, DynamicEntityDao)}
   */
  @Test
  public void testGetEnumerationValues_whenJavaLangComparable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> broadleafEnumerationUtility.getEnumerationValues("java.lang.Comparable", new DynamicEntityDaoImpl()));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  public void testGetSortedEnumValues_given42_whenHashMap42Is42_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    HashMap<Object, Object> typesMap = new HashMap<>();
    typesMap.put("42", "42");

    // Act
    Collection<Object> actualSortedEnumValues = broadleafEnumerationUtility.getSortedEnumValues(typesMap);

    // Assert
    assertTrue(actualSortedEnumValues instanceof List);
    assertEquals(1, actualSortedEnumValues.size());
    assertEquals("42", ((List<Object>) actualSortedEnumValues).get(0));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  public void testGetSortedEnumValues_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    HashMap<Object, Object> typesMap = new HashMap<>();
    typesMap.computeIfPresent("42", mock(BiFunction.class));
    typesMap.put("42", "42");

    // Act
    Collection<Object> actualSortedEnumValues = broadleafEnumerationUtility.getSortedEnumValues(typesMap);

    // Assert
    assertTrue(actualSortedEnumValues instanceof List);
    assertEquals(1, actualSortedEnumValues.size());
    assertEquals("42", ((List<Object>) actualSortedEnumValues).get(0));
  }

  /**
   * Test {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafEnumerationUtility#getSortedEnumValues(Map)}
   */
  @Test
  public void testGetSortedEnumValues_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafEnumerationUtility broadleafEnumerationUtility = new BroadleafEnumerationUtility();

    // Act
    Collection<Object> actualSortedEnumValues = broadleafEnumerationUtility.getSortedEnumValues(new HashMap<>());

    // Assert
    assertTrue(actualSortedEnumValues instanceof List);
    assertTrue(actualSortedEnumValues.isEmpty());
  }
}
