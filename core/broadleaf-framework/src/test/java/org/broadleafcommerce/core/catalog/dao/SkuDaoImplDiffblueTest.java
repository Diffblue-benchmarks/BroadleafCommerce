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

public class SkuDaoImplDiffblueTest {
  /**
   * Test {@link SkuDaoImpl#readSkusByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuDaoImpl#readSkusByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuDaoImpl.readSkusByIds(List)"})
  public void testReadSkusByIds_whenArrayList_thenReturnNull() {
    // Arrange
    SkuDaoImpl skuDaoImpl = new SkuDaoImpl();

    // Act and Assert
    assertNull(skuDaoImpl.readSkusByIds(new ArrayList<>()));
  }

  /**
   * Test {@link SkuDaoImpl#readSkusByIds(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuDaoImpl#readSkusByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuDaoImpl.readSkusByIds(List)"})
  public void testReadSkusByIds_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuDaoImpl()).readSkusByIds(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link SkuDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SkuDaoImpl.getCurrentDateResolution()", "void SkuDaoImpl.setCurrentDateResolution(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    SkuDaoImpl skuDaoImpl = new SkuDaoImpl();

    // Act
    skuDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, skuDaoImpl.getCurrentDateResolution().longValue());
  }
}
