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
package org.broadleafcommerce.common.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PropertyFilterDiffblueTest {
  /**
   * Method under test: {@link PropertyFilter#getJoinTableFilter()}
   */
  @Test
  public void testGetJoinTableFilter() {
    // Arrange, Act and Assert
    assertFalse((new PropertyFilter()).getJoinTableFilter());
  }

  /**
   * Method under test: {@link PropertyFilter#getJoinTableFilter()}
   */
  @Test
  public void testGetJoinTableFilter2() {
    // Arrange
    PropertyFilter propertyFilter = new PropertyFilter();
    propertyFilter.setJoinTableFilter(true);

    // Act and Assert
    assertTrue(propertyFilter.getJoinTableFilter());
  }

  /**
   * Method under test: {@link PropertyFilter#setJoinTableFilter(Boolean)}
   */
  @Test
  public void testSetJoinTableFilter() {
    // Arrange
    PropertyFilter propertyFilter = new PropertyFilter();

    // Act
    propertyFilter.setJoinTableFilter(true);

    // Assert
    assertTrue(propertyFilter.getJoinTableFilter());
    assertTrue(propertyFilter.isJoinTableFilter);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PropertyFilter}
   *   <li>{@link PropertyFilter#setPropertyName(String)}
   *   <li>{@link PropertyFilter#getPropertyName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PropertyFilter actualPropertyFilter = new PropertyFilter();
    actualPropertyFilter.setPropertyName("Property Name");

    // Assert that nothing has changed
    assertEquals("Property Name", actualPropertyFilter.getPropertyName());
  }
}
