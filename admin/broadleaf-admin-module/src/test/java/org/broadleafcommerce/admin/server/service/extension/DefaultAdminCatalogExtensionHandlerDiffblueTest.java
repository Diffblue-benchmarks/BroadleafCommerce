/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.junit.Test;

public class DefaultAdminCatalogExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  public void testPersistSkuPermutation_givenArrayList_whenProductBundleImpl_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();
    permutationsToGenerate.add(new ArrayList<>());

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED,
        defaultAdminCatalogExtensionHandler.persistSkuPermutation(product, permutationsToGenerate, erh));
  }

  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) Result intValue
   * is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  public void testPersistSkuPermutation_thenExtensionResultHolderResultIntValueIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPersistSkuPermutationResult = defaultAdminCatalogExtensionHandler
        .persistSkuPermutation(product, permutationsToGenerate, erh);

    // Assert
    assertEquals(0, erh.getResult().intValue());
    assertEquals(ExtensionResultStatusType.HANDLED, actualPersistSkuPermutationResult);
  }

  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) Result intValue
   * is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  public void testPersistSkuPermutation_thenExtensionResultHolderResultIntValueIsZero2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();
    permutationsToGenerate.add(new ArrayList<>());
    permutationsToGenerate.add(new ArrayList<>());

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPersistSkuPermutationResult = defaultAdminCatalogExtensionHandler
        .persistSkuPermutation(product, permutationsToGenerate, erh);

    // Assert
    assertEquals(0, erh.getResult().intValue());
    assertEquals(ExtensionResultStatusType.HANDLED, actualPersistSkuPermutationResult);
  }

  /**
   * Test
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List, ExtensionResultHolder)}
   */
  @Test
  public void testPersistSkuPermutation_whenArrayList_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler = new DefaultAdminCatalogExtensionHandler();
    ProductBundleImpl product = new ProductBundleImpl();
    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED,
        defaultAdminCatalogExtensionHandler.persistSkuPermutation(product, permutationsToGenerate, erh));
  }

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link DefaultAdminCatalogExtensionHandler#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(AdminCatalogServiceExtensionHandler.DEFAULT_PRIORITY,
        (new DefaultAdminCatalogExtensionHandler()).getPriority());
  }
}
