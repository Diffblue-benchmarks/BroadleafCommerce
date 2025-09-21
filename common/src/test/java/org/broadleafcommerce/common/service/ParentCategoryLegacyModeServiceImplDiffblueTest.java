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
package org.broadleafcommerce.common.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ParentCategoryLegacyModeServiceImplDiffblueTest {
  /**
   * Test {@link ParentCategoryLegacyModeServiceImpl#isLegacyMode()}.
   *
   * <p>Method under test: {@link ParentCategoryLegacyModeServiceImpl#isLegacyMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentCategoryLegacyModeServiceImpl.isLegacyMode()",
    "void ParentCategoryLegacyModeServiceImpl.setApplicationContext(org.springframework.context.ApplicationContext)"
  })
  public void testIsLegacyMode() {
    // Arrange, Act and Assert
    assertFalse(new ParentCategoryLegacyModeServiceImpl().isLegacyMode());
  }

  /**
   * Test {@link ParentCategoryLegacyModeServiceImpl#getLegacyModeService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParentCategoryLegacyModeServiceImpl#getLegacyModeService()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.service.ParentCategoryLegacyModeService ParentCategoryLegacyModeServiceImpl.getLegacyModeService()"
  })
  public void testGetLegacyModeService_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ParentCategoryLegacyModeServiceImpl.getLegacyModeService());
  }
}
