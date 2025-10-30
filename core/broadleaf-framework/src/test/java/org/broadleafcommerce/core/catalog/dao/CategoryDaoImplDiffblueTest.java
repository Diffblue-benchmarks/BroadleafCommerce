/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoryDaoImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link CategoryDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long CategoryDaoImpl.getCurrentDateResolution()",
      "void CategoryDaoImpl.setCurrentDateResolution(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();

    // Act
    categoryDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, categoryDaoImpl.getCurrentDateResolution().longValue());
  }
}
