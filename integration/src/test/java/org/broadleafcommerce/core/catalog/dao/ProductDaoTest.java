/*-
 * #%L
 * BroadleafCommerce Integration
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

import org.broadleafcommerce.core.catalog.ProductDataProvider;
import org.broadleafcommerce.core.catalog.domain.CrossSaleProductImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.RelatedProduct;
import org.broadleafcommerce.core.catalog.domain.UpSaleProductImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.test.TestNGSiteIntegrationSetup;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import java.util.List;
import javax.annotation.Resource;

public class ProductDaoTest extends TestNGSiteIntegrationSetup {
  @Resource private ProductDao productDao;

  @Resource private CatalogService catalogService;

  private static RelatedProduct getRelatedUpSaleProduct(
      Product prod, Product prodToRelate, List<RelatedProduct> upSales) {
    RelatedProduct rp1 = new UpSaleProductImpl();
    rp1.setProduct(prod);
    rp1.setPromotionMessage("brand new coffee");
    rp1.setRelatedProduct(prodToRelate);
    upSales.add(rp1);
    return rp1;
  }

  private static RelatedProduct getRelatedCrossProduct(
      Product prod, Product prodToRelate, List<RelatedProduct> upSales) {
    RelatedProduct rp1 = new CrossSaleProductImpl();
    rp1.setProduct(prod);
    rp1.setPromotionMessage("brand new coffee");
    rp1.setRelatedProduct(prodToRelate);
    upSales.add(rp1);
    return rp1;
  }

  @Test(dataProvider = "basicProduct", dataProviderClass = ProductDataProvider.class)
  @Transactional
  public void testReadProductsById(Product product) {
    product = catalogService.saveProduct(product);
    Product result = productDao.readProductById(product.getId());
    assert product.equals(result);
  }

  @Test(dataProvider = "basicProduct", dataProviderClass = ProductDataProvider.class)
  @Transactional
  public void testReadProductsByName(Product product) {
    String name = product.getName();
    product = catalogService.saveProduct(product);
    List<Product> result = productDao.readProductsByName(name);
    assert result.contains(product);
  }

  @Test(dataProvider = "basicProduct", dataProviderClass = ProductDataProvider.class)
  @Transactional
  public void testReadArchivedProductsByName(Product product) {
    String name = product.getName();
    product = catalogService.saveProduct(product);
    catalogService.removeProduct(product);
    List<Product> result = productDao.readProductsByName(name);
    assert result.isEmpty();
  }

  @Test(dataProvider = "basicProduct", dataProviderClass = ProductDataProvider.class)
  @Transactional
  public void testFeaturedProduct(Product product) {
    product = catalogService.saveProduct(product);
    Long productId = product.getId();
    product.setFeaturedProduct(true);
    catalogService.saveProduct(product);
    Product testProduct = productDao.readProductById(productId);
    assert (testProduct.isFeaturedProduct() == true);
  }
}
