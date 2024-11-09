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
package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ProductDaoImplDiffblueTest {
  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  public void testReadProductsByIds_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    // Act and Assert
    assertNull(productDaoImpl.readProductsByIds(new ArrayList<>()));
  }

  /**
   * Test {@link ProductDaoImpl#readProductsByIds(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductDaoImpl#readProductsByIds(List)}
   */
  @Test
  public void testReadProductsByIds_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductDaoImpl()).readProductsByIds(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link ProductDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    // Act
    productDaoImpl.setCurrentDateResolution(1L);

    // Assert that nothing has changed
    assertEquals(1L, productDaoImpl.getCurrentDateResolution().longValue());
  }
}
