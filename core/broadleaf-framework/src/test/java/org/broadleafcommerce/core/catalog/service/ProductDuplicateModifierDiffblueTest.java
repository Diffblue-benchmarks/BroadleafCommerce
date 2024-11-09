/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.copy.MultiTenantCloneable;
import org.junit.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;

public class ProductDuplicateModifierDiffblueTest {
  /**
   * Test {@link ProductDuplicateModifier#canHandle(MultiTenantCloneable)}.
   * <ul>
   *   <li>When {@link MultiTenantCloneable}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductDuplicateModifier#canHandle(MultiTenantCloneable)}
   */
  @Test
  public void testCanHandle_whenMultiTenantCloneable_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductDuplicateModifier(new StandardReactiveWebEnvironment()))
        .canHandle(mock(MultiTenantCloneable.class)));
  }
}
