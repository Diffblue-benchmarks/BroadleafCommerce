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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SortedListFactoryBeanDiffblueTest {
  /**
   * Test {@link SortedListFactoryBean#createInstance()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SortedListFactoryBean#createInstance()}
   */
  @Test
  public void testCreateInstance_thenReturnEmpty() {
    // Arrange
    SortedListFactoryBean sortedListFactoryBean = new SortedListFactoryBean();
    sortedListFactoryBean.setSourceList(new ArrayList<>());

    // Act and Assert
    assertTrue(sortedListFactoryBean.createInstance().isEmpty());
  }

  /**
   * Test new {@link SortedListFactoryBean} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SortedListFactoryBean}
   */
  @Test
  public void testNewSortedListFactoryBean() {
    // Arrange and Act
    SortedListFactoryBean actualSortedListFactoryBean = new SortedListFactoryBean();

    // Assert
    assertTrue(actualSortedListFactoryBean.isSingleton());
    Class<List> expectedObjectType = List.class;
    assertEquals(expectedObjectType, actualSortedListFactoryBean.getObjectType());
  }
}
