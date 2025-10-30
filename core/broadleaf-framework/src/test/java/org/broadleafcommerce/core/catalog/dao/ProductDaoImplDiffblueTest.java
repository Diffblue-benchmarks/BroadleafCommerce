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
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductDaoImpl.readProductsByIds(List)"})
  public void testReadProductsByIds_whenArrayList_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductDaoImpl.readProductsByIds(List)"})
  public void testReadProductsByIds_whenNull_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long ProductDaoImpl.getCurrentDateResolution()",
      "void ProductDaoImpl.setCurrentDateResolution(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    // Act
    productDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, productDaoImpl.getCurrentDateResolution().longValue());
  }
}
