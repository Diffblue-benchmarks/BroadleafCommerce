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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationStrategyType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductOptionImplDiffblueTest {
  /**
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getName());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  public void testGetName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setName("");

    // Act and Assert
    assertEquals("Label", productOptionImpl.getName());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  public void testGetName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setName("foo");

    // Act and Assert
    assertEquals("foo", productOptionImpl.getName());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  public void testGetName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = mock(
        ProductOptionValidationStrategyType.class);
    when(productOptionValidationStrategyType.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setProductOptionValidationStrategyType(productOptionValidationStrategyType);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setName("");

    // Act
    String actualName = productOptionImpl.getName();

    // Assert
    verify(productOptionValidationStrategyType).getType();
    assertEquals("Label", actualName);
  }

  /**
   * Method under test: {@link ProductOptionImpl#getType()}
   */
  @Test
  public void testGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getType());
  }

  /**
   * Method under test: {@link ProductOptionImpl#setType(ProductOptionType)}
   */
  @Test
  public void testSetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    ProductOptionType type = ProductOptionType.BOOLEAN;

    // Act
    productOptionImpl.setType(type);

    // Assert
    assertEquals("BOOLEAN", productOptionImpl.type);
    ProductOptionType expectedType = type.BOOLEAN;
    assertSame(expectedType, productOptionImpl.getType());
  }

  /**
   * Method under test: {@link ProductOptionImpl#setType(ProductOptionType)}
   */
  @Test
  public void testSetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act
    productOptionImpl.setType(null);

    // Assert
    assertNull(productOptionImpl.type);
    assertNull(productOptionImpl.getType());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getLabel()}
   */
  @Test
  public void testGetLabel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getLabel());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getLabel()}
   */
  @Test
  public void testGetLabel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionType type = mock(ProductOptionType.class);
    when(type.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setType(type);

    // Act
    String actualLabel = productOptionImpl.getLabel();

    // Assert
    verify(type).getType();
    assertNull(actualLabel);
  }

  /**
   * Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  public void testGetProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductOptionImpl()).getProducts().isEmpty());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  public void testGetProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ProductOptionXref> xrefs = new ArrayList<>();
    xrefs.add(new ProductOptionXrefImpl());

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setProductXrefs(xrefs);

    // Act
    List<Product> actualProducts = productOptionImpl.getProducts();

    // Assert
    assertEquals(1, actualProducts.size());
    Product getResult = actualProducts.get(0);
    assertTrue(getResult instanceof ProductImpl);
    FieldEntity fieldEntityType = getResult.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) getResult).archiveStatus.getArchived().charValue());
    assertEquals('N', ((ProductImpl) getResult).getArchived().charValue());
    assertNull(getResult.getId());
    assertNull(getResult.getCanonicalUrl());
    assertNull(getResult.getDisplayTemplate());
    assertNull(getResult.getGeneratedUrl());
    assertNull(getResult.getManufacturer());
    assertNull(getResult.getMetaDescription());
    assertNull(getResult.getMetaTitle());
    assertNull(getResult.getModel());
    assertNull(getResult.getPromoMessage());
    assertNull(getResult.getUrl());
    assertNull(((ProductImpl) getResult).getLocation());
    assertNull(((ProductImpl) getResult).url);
    assertNull(((ProductImpl) getResult).urlKey);
    assertNull(getResult.getPrice());
    assertNull(getResult.getRetailPrice());
    assertNull(getResult.getSalePrice());
    assertNull(((ProductImpl) getResult).getRetailPriceInternal());
    assertNull(((ProductImpl) getResult).getSalePriceInternal());
    assertNull(getResult.getCategory());
    assertNull(getResult.getDefaultCategory());
    assertNull(((ProductImpl) getResult).defaultCategory);
    List<Sku> allSellableSkus = getResult.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    List<Sku> allSkus = getResult.getAllSkus();
    assertEquals(1, allSkus.size());
    assertNull(allSkus.get(0));
    assertNull(getResult.getDefaultSku());
    assertFalse(getResult.getCanSellWithoutOptions());
    assertFalse(getResult.getOverrideGeneratedUrl());
    assertFalse(getResult.hasRetailPrice());
    assertFalse(((ProductImpl) getResult).canSellWithoutOptions);
    assertFalse(((ProductImpl) getResult).isFeaturedProduct);
    assertFalse(((ProductImpl) getResult).overrideGeneratedUrl);
    assertTrue(getResult.getAdditionalSkus().isEmpty());
    assertTrue(getResult.getAllParentCategories().isEmpty());
    assertTrue(getResult.getAllParentCategoryIds().isEmpty());
    assertTrue(getResult.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = getResult.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = getResult.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(getResult.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getProductOptionXrefs().isEmpty());
    assertTrue(getResult.getProductOptions().isEmpty());
    assertTrue(getResult.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(((ProductImpl) getResult).productAttributes.isEmpty());
    assertTrue(((ProductImpl) getResult).productOptions.isEmpty());
    assertTrue(((ProductImpl) getResult).skus.isEmpty());
    assertTrue(getResult.getMultiValueProductAttributes().isEmpty());
    assertTrue(getResult.getProductAttributes().isEmpty());
    assertTrue(getResult.getProductOptionValuesMap().isEmpty());
    assertSame(crossSaleProducts, getResult.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, getResult.getUpSaleProducts());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  public void testGetProducts3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = mock(
        ProductOptionValidationStrategyType.class);
    when(productOptionValidationStrategyType.getType()).thenReturn("Type");

    ArrayList<ProductOptionXref> xrefs = new ArrayList<>();
    xrefs.add(new ProductOptionXrefImpl());

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(productOptionValidationStrategyType);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setProductXrefs(xrefs);

    // Act
    List<Product> actualProducts = productOptionImpl.getProducts();

    // Assert
    verify(productOptionValidationStrategyType).getType();
    assertEquals(1, actualProducts.size());
    Product getResult = actualProducts.get(0);
    assertTrue(getResult instanceof ProductImpl);
    FieldEntity fieldEntityType = getResult.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) getResult).archiveStatus.getArchived().charValue());
    assertEquals('N', ((ProductImpl) getResult).getArchived().charValue());
    assertNull(getResult.getId());
    assertNull(getResult.getCanonicalUrl());
    assertNull(getResult.getDisplayTemplate());
    assertNull(getResult.getGeneratedUrl());
    assertNull(getResult.getManufacturer());
    assertNull(getResult.getMetaDescription());
    assertNull(getResult.getMetaTitle());
    assertNull(getResult.getModel());
    assertNull(getResult.getPromoMessage());
    assertNull(getResult.getUrl());
    assertNull(((ProductImpl) getResult).getLocation());
    assertNull(((ProductImpl) getResult).url);
    assertNull(((ProductImpl) getResult).urlKey);
    assertNull(getResult.getPrice());
    assertNull(getResult.getRetailPrice());
    assertNull(getResult.getSalePrice());
    assertNull(((ProductImpl) getResult).getRetailPriceInternal());
    assertNull(((ProductImpl) getResult).getSalePriceInternal());
    assertNull(getResult.getCategory());
    assertNull(getResult.getDefaultCategory());
    assertNull(((ProductImpl) getResult).defaultCategory);
    List<Sku> allSellableSkus = getResult.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    List<Sku> allSkus = getResult.getAllSkus();
    assertEquals(1, allSkus.size());
    assertNull(allSkus.get(0));
    assertNull(getResult.getDefaultSku());
    assertFalse(getResult.getCanSellWithoutOptions());
    assertFalse(getResult.getOverrideGeneratedUrl());
    assertFalse(getResult.hasRetailPrice());
    assertFalse(((ProductImpl) getResult).canSellWithoutOptions);
    assertFalse(((ProductImpl) getResult).isFeaturedProduct);
    assertFalse(((ProductImpl) getResult).overrideGeneratedUrl);
    assertTrue(getResult.getAdditionalSkus().isEmpty());
    assertTrue(getResult.getAllParentCategories().isEmpty());
    assertTrue(getResult.getAllParentCategoryIds().isEmpty());
    assertTrue(getResult.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = getResult.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = getResult.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(getResult.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getProductOptionXrefs().isEmpty());
    assertTrue(getResult.getProductOptions().isEmpty());
    assertTrue(getResult.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(((ProductImpl) getResult).productAttributes.isEmpty());
    assertTrue(((ProductImpl) getResult).productOptions.isEmpty());
    assertTrue(((ProductImpl) getResult).skus.isEmpty());
    assertTrue(getResult.getMultiValueProductAttributes().isEmpty());
    assertTrue(getResult.getProductAttributes().isEmpty());
    assertTrue(getResult.getProductOptionValuesMap().isEmpty());
    assertSame(crossSaleProducts, getResult.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, getResult.getUpSaleProducts());
  }

  /**
   * Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  public void testSetProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productOptionImpl.setProducts(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  public void testSetProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productOptionImpl.setProducts(products));
  }

  /**
   * Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  public void testSetProducts3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productOptionImpl.setProducts(products));
  }

  /**
   * Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  public void testGetUseInSkuGeneration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductOptionImpl()).getUseInSkuGeneration());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  public void testGetUseInSkuGeneration2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setUseInSkuGeneration(null);

    // Act and Assert
    assertTrue(productOptionImpl.getUseInSkuGeneration());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  public void testGetUseInSkuGeneration3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = mock(
        ProductOptionValidationStrategyType.class);
    when(productOptionValidationStrategyType.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(productOptionValidationStrategyType);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setUseInSkuGeneration(null);

    // Act
    Boolean actualUseInSkuGeneration = productOptionImpl.getUseInSkuGeneration();

    // Assert
    verify(productOptionValidationStrategyType).getType();
    assertTrue(actualUseInSkuGeneration);
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#getProductOptionValidationStrategyType()}
   */
  @Test
  public void testGetProductOptionValidationStrategyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getProductOptionValidationStrategyType());
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#getProductOptionValidationStrategyType()}
   */
  @Test
  public void testGetProductOptionValidationStrategyType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionType type = mock(ProductOptionType.class);
    when(type.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setType(type);

    // Act
    ProductOptionValidationStrategyType actualProductOptionValidationStrategyType = productOptionImpl
        .getProductOptionValidationStrategyType();

    // Assert
    verify(type).getType();
    assertNull(actualProductOptionValidationStrategyType);
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}
   */
  @Test
  public void testSetProductOptionValidationStrategyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    ProductOptionValidationStrategyType productOptionValidationStrategyType = ProductOptionValidationStrategyType.ADD_ITEM;

    // Act
    productOptionImpl.setProductOptionValidationStrategyType(productOptionValidationStrategyType);

    // Assert
    ProductOptionValidationStrategyType expectedProductOptionValidationStrategyType = productOptionValidationStrategyType.ADD_ITEM;
    assertSame(expectedProductOptionValidationStrategyType, productOptionImpl.getProductOptionValidationStrategyType());
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}
   */
  @Test
  public void testSetProductOptionValidationStrategyType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act
    productOptionImpl.setProductOptionValidationStrategyType(null);

    // Assert
    assertNull(productOptionImpl.getProductOptionValidationStrategyType());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  public void testGetProductOptionValidationType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductOptionValidationType actualProductOptionValidationType = (new ProductOptionImpl())
        .getProductOptionValidationType();

    // Assert
    assertSame(actualProductOptionValidationType.REGEX, actualProductOptionValidationType);
  }

  /**
   * Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  public void testGetProductOptionValidationType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);

    // Act
    ProductOptionValidationType actualProductOptionValidationType = productOptionImpl.getProductOptionValidationType();

    // Assert
    assertSame(actualProductOptionValidationType.REGEX, actualProductOptionValidationType);
  }

  /**
   * Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  public void testGetProductOptionValidationType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = mock(
        ProductOptionValidationStrategyType.class);
    when(productOptionValidationStrategyType.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(productOptionValidationStrategyType);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);

    // Act
    ProductOptionValidationType actualProductOptionValidationType = productOptionImpl.getProductOptionValidationType();

    // Assert
    verify(productOptionValidationStrategyType).getType();
    assertSame(actualProductOptionValidationType.REGEX, actualProductOptionValidationType);
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#setProductOptionValidationType(ProductOptionValidationType)}
   */
  @Test
  public void testSetProductOptionValidationType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    ProductOptionValidationType productOptionValidationType = ProductOptionValidationType.REGEX;

    // Act
    productOptionImpl.setProductOptionValidationType(productOptionValidationType);

    // Assert
    ProductOptionValidationType expectedProductOptionValidationType = productOptionValidationType.REGEX;
    assertSame(expectedProductOptionValidationType, productOptionImpl.getProductOptionValidationType());
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#setProductOptionValidationType(ProductOptionValidationType)}
   */
  @Test
  public void testSetProductOptionValidationType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act
    productOptionImpl.setProductOptionValidationType(null);

    // Assert
    ProductOptionValidationType productOptionValidationType = productOptionImpl.getProductOptionValidationType();
    assertEquals("REGEX", productOptionValidationType.getType());
    assertEquals("Regular Expression", productOptionValidationType.getFriendlyType());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getErrorMessage()}
   */
  @Test
  public void testGetErrorMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getErrorMessage());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getErrorMessage()}
   */
  @Test
  public void testGetErrorMessage2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionType type = mock(ProductOptionType.class);
    when(type.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setType(type);

    // Act
    String actualErrorMessage = productOptionImpl.getErrorMessage();

    // Assert
    verify(type).getType();
    assertNull(actualErrorMessage);
  }

  /**
   * Method under test: {@link ProductOptionImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link ProductOptionImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionType type = mock(ProductOptionType.class);
    when(type.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setType(type);

    // Act
    String actualMainEntityName = productOptionImpl.getMainEntityName();

    // Assert
    verify(type).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult = productOptionImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.ProductOptionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    ProductOption clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof ProductOptionImpl);
    ProductOptionValidationType productOptionValidationType = clone.getProductOptionValidationType();
    assertEquals("REGEX", productOptionValidationType.getType());
    assertEquals("Regular Expression", productOptionValidationType.getFriendlyType());
    assertNull(clone.getRequired());
    assertNull(clone.getDisplayOrder());
    assertNull(clone.getId());
    assertNull(clone.getAttributeName());
    assertNull(clone.getErrorCode());
    assertNull(clone.getErrorMessage());
    assertNull(clone.getLabel());
    assertNull(clone.getName());
    assertNull(clone.getValidationString());
    assertNull(((ProductOptionImpl) clone).getMainEntityName());
    assertNull(((ProductOptionImpl) clone).errorMessage);
    assertNull(((ProductOptionImpl) clone).label);
    assertNull(((ProductOptionImpl) clone).name);
    assertNull(((ProductOptionImpl) clone).type);
    assertNull(clone.getType());
    assertNull(clone.getProductOptionValidationStrategyType());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(clone.getUseInSkuGeneration());
    assertTrue(clone.getAllowedValues().isEmpty());
    assertTrue(clone.getProductXrefs().isEmpty());
    assertTrue(clone.getProducts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult = productOptionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionType type = mock(ProductOptionType.class);
    when(type.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setType(type);

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(productOptionImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(type).getType();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionImpl#equals(Object)}
   *   <li>{@link ProductOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");

    // Act and Assert
    assertEquals(productOptionImpl, productOptionImpl2);
    int expectedHashCodeResult = productOptionImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionImpl#equals(Object)}
   *   <li>{@link ProductOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act and Assert
    assertEquals(productOptionImpl, productOptionImpl);
    int expectedHashCodeResult = productOptionImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionImpl.hashCode());
  }

  /**
   * Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName(null);
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");

    // Act and Assert
    assertNotEquals(productOptionImpl, productOptionImpl2);
  }

  /**
   * Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = mock(
        ProductOptionValidationStrategyType.class);
    when(productOptionValidationStrategyType.getType()).thenReturn("Type");

    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(productOptionValidationStrategyType);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");

    // Act and Assert
    assertNotEquals(productOptionImpl, productOptionImpl2);
  }

  /**
   * Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act and Assert
    assertNotEquals(productOptionImpl, null);
  }

  /**
   * Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act and Assert
    assertNotEquals(productOptionImpl, "Different type to ProductOptionImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionImpl#setAllowedValues(List)}
   *   <li>{@link ProductOptionImpl#setAttributeName(String)}
   *   <li>{@link ProductOptionImpl#setDisplayOrder(Integer)}
   *   <li>{@link ProductOptionImpl#setErrorCode(String)}
   *   <li>{@link ProductOptionImpl#setErrorMessage(String)}
   *   <li>{@link ProductOptionImpl#setId(Long)}
   *   <li>{@link ProductOptionImpl#setLabel(String)}
   *   <li>{@link ProductOptionImpl#setName(String)}
   *   <li>{@link ProductOptionImpl#setProductXrefs(List)}
   *   <li>{@link ProductOptionImpl#setRequired(Boolean)}
   *   <li>{@link ProductOptionImpl#setUseInSkuGeneration(Boolean)}
   *   <li>{@link ProductOptionImpl#setValidationString(String)}
   *   <li>{@link ProductOptionImpl#getAllowedValues()}
   *   <li>{@link ProductOptionImpl#getAttributeName()}
   *   <li>{@link ProductOptionImpl#getDisplayOrder()}
   *   <li>{@link ProductOptionImpl#getErrorCode()}
   *   <li>{@link ProductOptionImpl#getId()}
   *   <li>{@link ProductOptionImpl#getProductXrefs()}
   *   <li>{@link ProductOptionImpl#getRequired()}
   *   <li>{@link ProductOptionImpl#getValidationString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    ArrayList<ProductOptionValue> allowedValues = new ArrayList<>();

    // Act
    productOptionImpl.setAllowedValues(allowedValues);
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    ArrayList<ProductOptionXref> xrefs = new ArrayList<>();
    productOptionImpl.setProductXrefs(xrefs);
    productOptionImpl.setRequired(true);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    List<ProductOptionValue> actualAllowedValues = productOptionImpl.getAllowedValues();
    String actualAttributeName = productOptionImpl.getAttributeName();
    Integer actualDisplayOrder = productOptionImpl.getDisplayOrder();
    String actualErrorCode = productOptionImpl.getErrorCode();
    Long actualId = productOptionImpl.getId();
    List<ProductOptionXref> actualProductXrefs = productOptionImpl.getProductXrefs();
    Boolean actualRequired = productOptionImpl.getRequired();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualErrorCode);
    assertEquals("Attribute Name", actualAttributeName);
    assertEquals("Validation String", productOptionImpl.getValidationString());
    assertEquals(1, actualDisplayOrder.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAllowedValues.isEmpty());
    assertTrue(actualProductXrefs.isEmpty());
    assertTrue(actualRequired);
    assertSame(allowedValues, actualAllowedValues);
    assertSame(xrefs, actualProductXrefs);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ProductOptionImpl}
   */
  @Test
  public void testNewProductOptionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductOptionImpl actualProductOptionImpl = new ProductOptionImpl();

    // Assert
    ProductOptionValidationType productOptionValidationType = actualProductOptionImpl.getProductOptionValidationType();
    assertEquals("REGEX", productOptionValidationType.getType());
    assertEquals("Regular Expression", productOptionValidationType.getFriendlyType());
    assertNull(actualProductOptionImpl.getRequired());
    assertNull(actualProductOptionImpl.getDisplayOrder());
    assertNull(actualProductOptionImpl.getId());
    assertNull(actualProductOptionImpl.getAttributeName());
    assertNull(actualProductOptionImpl.getErrorCode());
    assertNull(actualProductOptionImpl.getErrorMessage());
    assertNull(actualProductOptionImpl.getLabel());
    assertNull(actualProductOptionImpl.getMainEntityName());
    assertNull(actualProductOptionImpl.getName());
    assertNull(actualProductOptionImpl.getValidationString());
    assertNull(actualProductOptionImpl.errorMessage);
    assertNull(actualProductOptionImpl.label);
    assertNull(actualProductOptionImpl.name);
    assertNull(actualProductOptionImpl.type);
    assertNull(actualProductOptionImpl.getType());
    assertNull(actualProductOptionImpl.getProductOptionValidationStrategyType());
    assertFalse(actualProductOptionImpl.getUseInSkuGeneration());
    assertTrue(actualProductOptionImpl.getAllowedValues().isEmpty());
    assertTrue(actualProductOptionImpl.getProductXrefs().isEmpty());
    assertTrue(actualProductOptionImpl.getProducts().isEmpty());
  }
}
