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
package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.type.Type;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HibernateMappingProviderDiffblueTest {
  /**
   * Test {@link HibernateMappingProvider#getMapping(String)}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getMapping(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PersistentClass HibernateMappingProvider.getMapping(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List HibernateMappingProvider.getPropertyNames(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List HibernateMappingProvider.getPropertyTypes(String)"})
  public void testGetPropertyTypes() {
    // Arrange and Act
    List<Type> actualPropertyTypes = HibernateMappingProvider.getPropertyTypes("Entity Class");

    // Assert
    assertTrue(actualPropertyTypes.isEmpty());
  }

  /**
   * Test {@link HibernateMappingProvider#getAllMappings()}.
   * <p>
   * Method under test: {@link HibernateMappingProvider#getAllMappings()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection HibernateMappingProvider.getAllMappings()"})
  public void testGetAllMappings() {
    // Arrange and Act
    Collection<PersistentClass> actualAllMappings = HibernateMappingProvider.getAllMappings();

    // Assert
    assertTrue(actualAllMappings.isEmpty());
  }
}
