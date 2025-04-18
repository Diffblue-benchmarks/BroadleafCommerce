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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductOptionDaoImplDiffblueTest {
  @InjectMocks
  private ProductOptionDaoImpl productOptionDaoImpl;

  @Mock
  private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductOptionDaoImpl.filterCandidateSkusForArchivedStatus(List)"})
  public void testFilterCandidateSkusForArchivedStatus_givenSkuImpl_thenReturnSizeIsOne() {
    // Arrange
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
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDaoImpl#filterCandidateSkusForArchivedStatus(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductOptionDaoImpl.filterCandidateSkusForArchivedStatus(List)"})
  public void testFilterCandidateSkusForArchivedStatus_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(productOptionDaoImpl.filterCandidateSkusForArchivedStatus(new ArrayList<>()).isEmpty());
  }
}
