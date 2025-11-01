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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXref;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXrefImpl;
import org.junit.Test;

public class SkuMediaServiceImplDiffblueTest {
  /**
   * Method under test: {@link SkuMediaServiceImpl#sort(List)}
   */
  @Test
  public void testSort() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMediaServiceImpl skuMediaServiceImpl = new SkuMediaServiceImpl();
    ArrayList<SkuMediaXref> skuMediaXrefs = new ArrayList<>();

    // Act
    List<SkuMediaXref> actualSortResult = skuMediaServiceImpl.sort(skuMediaXrefs);

    // Assert
    assertTrue(actualSortResult.isEmpty());
    assertSame(skuMediaXrefs, actualSortResult);
  }

  /**
   * Method under test: {@link SkuMediaServiceImpl#sort(List)}
   */
  @Test
  public void testSort2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMediaServiceImpl skuMediaServiceImpl = new SkuMediaServiceImpl();

    ArrayList<SkuMediaXref> skuMediaXrefs = new ArrayList<>();
    skuMediaXrefs.add(new SkuMediaXrefImpl());

    // Act and Assert
    assertSame(skuMediaXrefs, skuMediaServiceImpl.sort(skuMediaXrefs));
  }
}
