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
package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SkuActiveDateConsiderationContextDiffblueTest {
  /**
   * Test
   * {@link SkuActiveDateConsiderationContext#getSkuActiveDateConsiderationContext()}.
   * <p>
   * Method under test:
   * {@link SkuActiveDateConsiderationContext#getSkuActiveDateConsiderationContext()}
   */
  @Test
  public void testGetSkuActiveDateConsiderationContext() {
    // Arrange, Act and Assert
    assertNull(SkuActiveDateConsiderationContext.getSkuActiveDateConsiderationContext());
  }

  /**
   * Test {@link SkuActiveDateConsiderationContext#getSkuActiveDatesService()}.
   * <p>
   * Method under test:
   * {@link SkuActiveDateConsiderationContext#getSkuActiveDatesService()}
   */
  @Test
  public void testGetSkuActiveDatesService() {
    // Arrange, Act and Assert
    assertNull(SkuActiveDateConsiderationContext.getSkuActiveDatesService());
  }

  /**
   * Test {@link SkuActiveDateConsiderationContext#hasDynamicActiveDates()}.
   * <p>
   * Method under test:
   * {@link SkuActiveDateConsiderationContext#hasDynamicActiveDates()}
   */
  @Test
  public void testHasDynamicActiveDates() {
    // Arrange, Act and Assert
    assertFalse(SkuActiveDateConsiderationContext.hasDynamicActiveDates());
  }

  /**
   * Test new {@link SkuActiveDateConsiderationContext} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SkuActiveDateConsiderationContext}
   */
  @Test
  public void testNewSkuActiveDateConsiderationContext() {
    // Arrange and Act
    SkuActiveDateConsiderationContext actualSkuActiveDateConsiderationContext = new SkuActiveDateConsiderationContext();

    // Assert
    assertNull(actualSkuActiveDateConsiderationContext.considerations);
    assertNull(actualSkuActiveDateConsiderationContext.service);
  }
}
