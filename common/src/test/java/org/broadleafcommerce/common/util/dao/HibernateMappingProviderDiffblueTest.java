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
package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.hibernate.type.Type;
import org.junit.Test;

public class HibernateMappingProviderDiffblueTest {
  /**
   * Test {@link HibernateMappingProvider#getMapping(String)}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getMapping(String)}
   */
  @Test
  public void testGetMapping() {
    // Arrange, Act and Assert
    assertNull(HibernateMappingProvider.getMapping("Entity Class"));
  }

  /**
   * Test {@link HibernateMappingProvider#getPropertyNames(String)}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getPropertyNames(String)}
   */
  @Test
  public void testGetPropertyNames() {
    // Arrange and Act
    List<String> actualPropertyNames = HibernateMappingProvider.getPropertyNames("Entity Class");

    // Assert
    assertTrue(actualPropertyNames.isEmpty());
  }

  /**
   * Test {@link HibernateMappingProvider#getPropertyTypes(String)}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getPropertyTypes(String)}
   */
  @Test
  public void testGetPropertyTypes() {
    // Arrange and Act
    List<Type> actualPropertyTypes = HibernateMappingProvider.getPropertyTypes("Entity Class");

    // Assert
    assertTrue(actualPropertyTypes.isEmpty());
  }
}
