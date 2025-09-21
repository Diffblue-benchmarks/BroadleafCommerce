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
package org.broadleafcommerce.core.catalog.domain.pricing;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuPriceWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuPriceWrapper#SkuPriceWrapper(Sku)}
   *   <li>{@link SkuPriceWrapper#setTargetSku(Sku)}
   *   <li>{@link SkuPriceWrapper#getTargetSku()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuPriceWrapper.<init>(Sku)",
    "Sku SkuPriceWrapper.getTargetSku()",
    "void SkuPriceWrapper.setTargetSku(Sku)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuPriceWrapper actualSkuPriceWrapper = new SkuPriceWrapper(new SkuImpl());
    SkuImpl targetSku = new SkuImpl();
    actualSkuPriceWrapper.setTargetSku(targetSku);

    // Assert
    assertSame(targetSku, actualSkuPriceWrapper.getTargetSku());
  }

  /**
   * Test {@link SkuPriceWrapper#SkuPriceWrapper()}.
   *
   * <p>Method under test: {@link SkuPriceWrapper#SkuPriceWrapper()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuPriceWrapper.<init>()"})
  public void testNewSkuPriceWrapper() {
    // Arrange, Act and Assert
    assertTrue(new SkuPriceWrapper().getTargetSku() instanceof SkuImpl);
  }
}
