/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class DefaultAdminCatalogExtensionHandlerDiffblueTest {
  @Mock private AdminCatalogServiceExtensionManager adminCatalogServiceExtensionManager;

  @Mock private CatalogService catalogService;

  @InjectMocks private DefaultAdminCatalogExtensionHandler defaultAdminCatalogExtensionHandler;

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#init()}.
   *
   * <ul>
   *   <li>Then calls {@link AdminCatalogServiceExtensionManager#registerHandler(ExtensionHandler)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultAdminCatalogExtensionHandler#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultAdminCatalogExtensionHandler.init()"})
  public void testInit_thenCallsRegisterHandler() {
    // Arrange
    when(adminCatalogServiceExtensionManager.registerHandler(
            Mockito.<AdminCatalogServiceExtensionHandler>any()))
        .thenReturn(true);

    // Act
    defaultAdminCatalogExtensionHandler.init();

    // Assert
    verify(adminCatalogServiceExtensionManager)
        .registerHandler(isA(AdminCatalogServiceExtensionHandler.class));
  }

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product,
   * List, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType DefaultAdminCatalogExtensionHandler.persistSkuPermutation(Product, List, ExtensionResultHolder)"
  })
  public void testPersistSkuPermutation_givenArrayList_thenReturnHandled() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();
    permutationsToGenerate.add(new ArrayList<>());

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.HANDLED,
        defaultAdminCatalogExtensionHandler.persistSkuPermutation(
            product, permutationsToGenerate, erh));
    assertTrue(product.getAdditionalSkus().isEmpty());
  }

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Then {@link ProductBundleImpl} (default constructor) AdditionalSkus size is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product,
   * List, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType DefaultAdminCatalogExtensionHandler.persistSkuPermutation(Product, List, ExtensionResultHolder)"
  })
  public void testPersistSkuPermutation_thenProductBundleImplAdditionalSkusSizeIsOne() {
    // Arrange
    when(catalogService.saveProduct(Mockito.<Product>any())).thenReturn(new ProductBundleImpl());
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.saveSku(Mockito.<Sku>any())).thenReturn(skuImpl);
    when(catalogService.createSku()).thenReturn(new SkuImpl());
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<ProductOptionValue> productOptionValueList = new ArrayList<>();
    productOptionValueList.add(new ProductOptionValueImpl());

    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();
    permutationsToGenerate.add(productOptionValueList);

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act
    defaultAdminCatalogExtensionHandler.persistSkuPermutation(product, permutationsToGenerate, erh);

    // Assert
    verify(catalogService).createSku();
    verify(catalogService).saveProduct(isA(Product.class));
    verify(catalogService).saveSku(isA(Sku.class));
    List<Sku> additionalSkus = product.getAdditionalSkus();
    assertEquals(1, additionalSkus.size());
    Sku getResult = additionalSkus.get(0);
    assertTrue(getResult instanceof SkuImpl);
    assertSame(skuImpl, getResult);
  }

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product, List,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultAdminCatalogExtensionHandler#persistSkuPermutation(Product,
   * List, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType DefaultAdminCatalogExtensionHandler.persistSkuPermutation(Product, List, ExtensionResultHolder)"
  })
  public void testPersistSkuPermutation_whenArrayList_thenReturnHandled() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    ArrayList<List<ProductOptionValue>> permutationsToGenerate = new ArrayList<>();

    ExtensionResultHolder<Integer> erh = new ExtensionResultHolder<>();
    erh.setResult(1);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.HANDLED,
        defaultAdminCatalogExtensionHandler.persistSkuPermutation(
            product, permutationsToGenerate, erh));
    assertTrue(product.getAdditionalSkus().isEmpty());
  }

  /**
   * Test {@link DefaultAdminCatalogExtensionHandler#getPriority()}.
   *
   * <p>Method under test: {@link DefaultAdminCatalogExtensionHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultAdminCatalogExtensionHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(
        AdminCatalogServiceExtensionHandler.DEFAULT_PRIORITY,
        defaultAdminCatalogExtensionHandler.getPriority());
  }
}
