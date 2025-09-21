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
package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.MultiTenantCloneable;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductDuplicateModifierDiffblueTest {
  @InjectMocks private ProductDuplicateModifier productDuplicateModifier;

  /**
   * Test {@link ProductDuplicateModifier#canHandle(MultiTenantCloneable)}.
   *
   * <ul>
   *   <li>When {@link MultiTenantCloneable}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductDuplicateModifier#canHandle(MultiTenantCloneable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductDuplicateModifier.canHandle(MultiTenantCloneable)"})
  public void testCanHandle_whenMultiTenantCloneable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productDuplicateModifier.canHandle(mock(MultiTenantCloneable.class)));
  }
}
