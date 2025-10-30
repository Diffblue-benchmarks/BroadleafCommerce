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
package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OfferContextDiffblueTest {
  /**
   * Test {@link OfferContext#getOfferContext()}.
   * <p>
   * Method under test: {@link OfferContext#getOfferContext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferContext OfferContext.getOfferContext()"})
  public void testGetOfferContext() {
    // Arrange, Act and Assert
    assertTrue(OfferContext.getOfferContext().getExecutePromotionCalculation());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferContext}
   *   <li>{@link OfferContext#setExecutePromotionCalculation(Boolean)}
   *   <li>{@link OfferContext#getExecutePromotionCalculation()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferContext.<init>()", "Boolean OfferContext.getExecutePromotionCalculation()",
      "void OfferContext.setExecutePromotionCalculation(Boolean)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferContext actualOfferContext = new OfferContext();
    actualOfferContext.setExecutePromotionCalculation(true);

    // Assert
    assertTrue(actualOfferContext.getExecutePromotionCalculation());
  }
}
