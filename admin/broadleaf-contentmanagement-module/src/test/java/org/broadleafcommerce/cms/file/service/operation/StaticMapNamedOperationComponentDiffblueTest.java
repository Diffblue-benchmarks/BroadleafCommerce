/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.file.service.operation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class StaticMapNamedOperationComponentDiffblueTest {
  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  public void testSetOperationValues_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent = new StaticMapNamedOperationComponent();

    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.computeIfPresent("foo", mock(BiFunction.class));
    originalParameters.put("foo", "foo");

    // Act and Assert
    assertTrue(staticMapNamedOperationComponent.setOperationValues(originalParameters, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  public void testSetOperationValues_givenFoo_whenHashMapFooIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent = new StaticMapNamedOperationComponent();

    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.put("foo", "foo");

    // Act and Assert
    assertTrue(staticMapNamedOperationComponent.setOperationValues(originalParameters, new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  public void testSetOperationValues_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent = new StaticMapNamedOperationComponent();
    HashMap<String, String> originalParameters = new HashMap<>();

    // Act and Assert
    assertTrue(staticMapNamedOperationComponent.setOperationValues(originalParameters, new HashMap<>()).isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StaticMapNamedOperationComponent}
   *   <li>
   * {@link StaticMapNamedOperationComponent#setNamedOperations(LinkedHashMap)}
   *   <li>{@link StaticMapNamedOperationComponent#getNamedOperations()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticMapNamedOperationComponent actualStaticMapNamedOperationComponent = new StaticMapNamedOperationComponent();
    LinkedHashMap<String, LinkedHashMap<String, String>> namedOperations = new LinkedHashMap<>();
    actualStaticMapNamedOperationComponent.setNamedOperations(namedOperations);

    // Assert that nothing has changed
    assertSame(namedOperations, actualStaticMapNamedOperationComponent.getNamedOperations());
  }
}
