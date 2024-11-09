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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductOptionXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionXrefImpl#setId(Long)}
   *   <li>{@link ProductOptionXrefImpl#setProduct(Product)}
   *   <li>{@link ProductOptionXrefImpl#setProductOption(ProductOption)}
   *   <li>{@link ProductOptionXrefImpl#getId()}
   *   <li>{@link ProductOptionXrefImpl#getProduct()}
   *   <li>{@link ProductOptionXrefImpl#getProductOption()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductOptionXrefImpl productOptionXrefImpl = new ProductOptionXrefImpl();

    // Act
    productOptionXrefImpl.setId(1L);
    ProductBundleImpl product = new ProductBundleImpl();
    productOptionXrefImpl.setProduct(product);
    ProductOptionImpl productOption = new ProductOptionImpl();
    productOptionXrefImpl.setProductOption(productOption);
    Long actualId = productOptionXrefImpl.getId();
    Product actualProduct = productOptionXrefImpl.getProduct();
    ProductOption actualProductOption = productOptionXrefImpl.getProductOption();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(product, actualProduct);
    assertSame(productOption, actualProductOption);
  }

  /**
   * Test
   * {@link ProductOptionXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link ProductOptionXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionXrefImpl productOptionXrefImpl = new ProductOptionXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionXref> actualCreateOrRetrieveCopyInstanceResult = productOptionXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionXrefImpl#equals(Object)}, and
   * {@link ProductOptionXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionXrefImpl#equals(Object)}
   *   <li>{@link ProductOptionXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionXrefImpl productOptionXrefImpl = new ProductOptionXrefImpl();
    productOptionXrefImpl.setId(1L);
    productOptionXrefImpl.setProduct(new ProductBundleImpl());
    productOptionXrefImpl.setProductOption(new ProductOptionImpl());

    ProductOptionXrefImpl productOptionXrefImpl2 = new ProductOptionXrefImpl();
    productOptionXrefImpl2.setId(1L);
    productOptionXrefImpl2.setProduct(new ProductBundleImpl());
    productOptionXrefImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionXrefImpl, productOptionXrefImpl2);
    int expectedHashCodeResult = productOptionXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionXrefImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionXrefImpl#equals(Object)}, and
   * {@link ProductOptionXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionXrefImpl#equals(Object)}
   *   <li>{@link ProductOptionXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionXrefImpl productOptionXrefImpl = new ProductOptionXrefImpl();
    productOptionXrefImpl.setId(1L);
    productOptionXrefImpl.setProduct(new ProductBundleImpl());
    productOptionXrefImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionXrefImpl, productOptionXrefImpl);
    int expectedHashCodeResult = productOptionXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionXrefImpl.hashCode());
  }

  /**
   * Test {@link ProductOptionXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionXrefImpl productOptionXrefImpl = new ProductOptionXrefImpl();
    productOptionXrefImpl.setId(2L);
    productOptionXrefImpl.setProduct(new ProductBundleImpl());
    productOptionXrefImpl.setProductOption(new ProductOptionImpl());

    ProductOptionXrefImpl productOptionXrefImpl2 = new ProductOptionXrefImpl();
    productOptionXrefImpl2.setId(1L);
    productOptionXrefImpl2.setProduct(new ProductBundleImpl());
    productOptionXrefImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionXrefImpl, productOptionXrefImpl2);
  }

  /**
   * Test {@link ProductOptionXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionXrefImpl productOptionXrefImpl = new ProductOptionXrefImpl();
    productOptionXrefImpl.setId(1L);
    productOptionXrefImpl.setProduct(mock(ProductBundleImpl.class));
    productOptionXrefImpl.setProductOption(new ProductOptionImpl());

    ProductOptionXrefImpl productOptionXrefImpl2 = new ProductOptionXrefImpl();
    productOptionXrefImpl2.setId(1L);
    productOptionXrefImpl2.setProduct(new ProductBundleImpl());
    productOptionXrefImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionXrefImpl, productOptionXrefImpl2);
  }

  /**
   * Test {@link ProductOptionXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductOptionXrefImpl productOptionXrefImpl = new ProductOptionXrefImpl();
    productOptionXrefImpl.setId(1L);
    productOptionXrefImpl.setProduct(new ProductBundleImpl());
    productOptionXrefImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionXrefImpl, null);
  }

  /**
   * Test {@link ProductOptionXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductOptionXrefImpl productOptionXrefImpl = new ProductOptionXrefImpl();
    productOptionXrefImpl.setId(1L);
    productOptionXrefImpl.setProduct(new ProductBundleImpl());
    productOptionXrefImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionXrefImpl, "Different type to ProductOptionXrefImpl");
  }

  /**
   * Test new {@link ProductOptionXrefImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductOptionXrefImpl}
   */
  @Test
  public void testNewProductOptionXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductOptionXrefImpl actualProductOptionXrefImpl = new ProductOptionXrefImpl();

    // Assert
    Product product = actualProductOptionXrefImpl.getProduct();
    assertTrue(product instanceof ProductImpl);
    ProductOption productOption = actualProductOptionXrefImpl.getProductOption();
    assertTrue(productOption instanceof ProductOptionImpl);
    FieldEntity fieldEntityType = product.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    ProductOptionValidationType productOptionValidationType = productOption.getProductOptionValidationType();
    assertEquals("REGEX", productOptionValidationType.getType());
    assertEquals("Regular Expression", productOptionValidationType.getFriendlyType());
    assertEquals('N', ((ProductImpl) product).archiveStatus.getArchived().charValue());
    assertEquals('N', ((ProductImpl) product).getArchived().charValue());
    assertNull(productOption.getRequired());
    assertNull(productOption.getDisplayOrder());
    assertNull(product.getId());
    assertNull(productOption.getId());
    assertNull(actualProductOptionXrefImpl.getId());
    assertNull(product.getCanonicalUrl());
    assertNull(product.getDisplayTemplate());
    assertNull(product.getGeneratedUrl());
    assertNull(product.getManufacturer());
    assertNull(product.getMetaDescription());
    assertNull(product.getMetaTitle());
    assertNull(product.getModel());
    assertNull(product.getPromoMessage());
    assertNull(product.getUrl());
    assertNull(((ProductImpl) product).getLocation());
    assertNull(productOption.getAttributeName());
    assertNull(productOption.getErrorCode());
    assertNull(productOption.getErrorMessage());
    assertNull(productOption.getLabel());
    assertNull(productOption.getName());
    assertNull(productOption.getValidationString());
    assertNull(((ProductOptionImpl) productOption).getMainEntityName());
    assertNull(((ProductImpl) product).url);
    assertNull(((ProductImpl) product).urlKey);
    assertNull(((ProductOptionImpl) productOption).errorMessage);
    assertNull(((ProductOptionImpl) productOption).label);
    assertNull(((ProductOptionImpl) productOption).name);
    assertNull(((ProductOptionImpl) productOption).type);
    assertNull(product.getPrice());
    assertNull(product.getRetailPrice());
    assertNull(product.getSalePrice());
    assertNull(((ProductImpl) product).getRetailPriceInternal());
    assertNull(((ProductImpl) product).getSalePriceInternal());
    assertNull(product.getCategory());
    assertNull(product.getDefaultCategory());
    assertNull(((ProductImpl) product).defaultCategory);
    List<Sku> allSellableSkus = product.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(product.getDefaultSku());
    assertNull(productOption.getType());
    assertNull(productOption.getProductOptionValidationStrategyType());
    assertFalse(product.getCanSellWithoutOptions());
    assertFalse(product.getOverrideGeneratedUrl());
    assertFalse(product.hasRetailPrice());
    assertFalse(productOption.getUseInSkuGeneration());
    assertFalse(((ProductImpl) product).canSellWithoutOptions);
    assertFalse(((ProductImpl) product).isFeaturedProduct);
    assertFalse(((ProductImpl) product).overrideGeneratedUrl);
    assertTrue(product.getAdditionalSkus().isEmpty());
    assertTrue(product.getAllParentCategories().isEmpty());
    assertTrue(product.getAllParentCategoryIds().isEmpty());
    assertTrue(product.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = product.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = product.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(product.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(product.getProductOptionXrefs().isEmpty());
    assertTrue(product.getProductOptions().isEmpty());
    assertTrue(product.getSkus().isEmpty());
    assertTrue(productOption.getAllowedValues().isEmpty());
    assertTrue(productOption.getProductXrefs().isEmpty());
    assertTrue(productOption.getProducts().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(((ProductImpl) product).productAttributes.isEmpty());
    assertTrue(((ProductImpl) product).productOptions.isEmpty());
    assertTrue(((ProductImpl) product).skus.isEmpty());
    assertTrue(product.getMultiValueProductAttributes().isEmpty());
    assertTrue(product.getProductAttributes().isEmpty());
    assertTrue(product.getProductOptionValuesMap().isEmpty());
    assertEquals(allSellableSkus, product.getAllSkus());
    assertSame(crossSaleProducts, product.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, product.getUpSaleProducts());
  }
}
