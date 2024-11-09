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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;

public class ProductOptionDaoImplDiffblueTest {
  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  public void testFilterCandidateSkusForArchivedStatus_givenSkuImpl_thenReturnFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl = new ProductOptionDaoImpl();

    ArrayList<Sku> candidateSkus = new ArrayList<>();
    candidateSkus.add(new SkuImpl());

    // Act
    List<Long> actualFilterCandidateSkusForArchivedStatusResult = productOptionDaoImpl
        .filterCandidateSkusForArchivedStatus(candidateSkus);

    // Assert
    assertEquals(1, actualFilterCandidateSkusForArchivedStatusResult.size());
    assertNull(actualFilterCandidateSkusForArchivedStatusResult.get(0));
  }

  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   * <ul>
   *   <li>Then return first longValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  public void testFilterCandidateSkusForArchivedStatus_thenReturnFirstLongValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl = new ProductOptionDaoImpl();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    ArrayList<Sku> candidateSkus = new ArrayList<>();
    candidateSkus.add(skuImpl);

    // Act
    List<Long> actualFilterCandidateSkusForArchivedStatusResult = productOptionDaoImpl
        .filterCandidateSkusForArchivedStatus(candidateSkus);

    // Assert
    verify(skuImpl).getId();
    assertEquals(1, actualFilterCandidateSkusForArchivedStatusResult.size());
    assertEquals(1L, actualFilterCandidateSkusForArchivedStatusResult.get(0).longValue());
  }

  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  public void testFilterCandidateSkusForArchivedStatus_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionDaoImpl productOptionDaoImpl = new ProductOptionDaoImpl();

    // Act and Assert
    assertTrue(productOptionDaoImpl.filterCandidateSkusForArchivedStatus(new ArrayList<>()).isEmpty());
  }
}
