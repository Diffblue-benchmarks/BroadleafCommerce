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
package org.broadleafcommerce.core.search.dao;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SolrIndexDaoImplDiffblueTest {
  @Mock private SandBoxHelper sandBoxHelper;

  @InjectMocks private SolrIndexDaoImpl solrIndexDaoImpl;

  /**
   * Test {@link SolrIndexDaoImpl#populateProductCatalogStructure(List, CatalogStructure)}.
   *
   * <ul>
   *   <li>Then calls {@link SandBoxHelper#getSandBoxToOriginalMap(Class, Long[])}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexDaoImpl#populateProductCatalogStructure(List,
   * CatalogStructure)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexDaoImpl.populateProductCatalogStructure(List, CatalogStructure)"
  })
  public void testPopulateProductCatalogStructure_thenCallsGetSandBoxToOriginalMap() {
    // Arrange
    when(sandBoxHelper.getSandBoxToOriginalMap(Mockito.<Class<?>>any(), (Long[]) Mockito.any()))
        .thenReturn(null);
    ArrayList<Long> productIds = new ArrayList<>();

    CatalogStructure catalogStructure = new CatalogStructure();
    catalogStructure.setDisplayOrdersByCategoryProduct(new HashMap<>());
    catalogStructure.setParentCategoriesByCategory(new HashMap<>());
    catalogStructure.setParentCategoriesByProduct(new HashMap<>());

    // Act
    solrIndexDaoImpl.populateProductCatalogStructure(productIds, catalogStructure);

    // Assert
    verify(sandBoxHelper).getSandBoxToOriginalMap(isA(Class.class), (Long[]) Mockito.any());
  }
}
