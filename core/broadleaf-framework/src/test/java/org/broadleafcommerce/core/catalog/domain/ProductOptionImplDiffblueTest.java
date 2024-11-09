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
   * Test {@link ProductOptionImpl#getName()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor) Name is
   * {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  public void testGetName_givenProductOptionImplNameIsFoo_thenReturnFoo() {
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
   * Test {@link ProductOptionImpl#getName()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  public void testGetName_givenProductOptionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getName());
  }

  /**
   * Test {@link ProductOptionImpl#getName()}.
   * <ul>
   *   <li>Then calls {@link ProductOptionValidationStrategyType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  public void testGetName_thenCallsGetType() {
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
   * Test {@link ProductOptionImpl#getName()}.
   * <ul>
   *   <li>Then return {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  public void testGetName_thenReturnLabel() {
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
   * Test {@link ProductOptionImpl#getType()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getType()}
   */
  @Test
  public void testGetType_givenProductOptionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getType());
  }

  /**
   * Test {@link ProductOptionImpl#setType(ProductOptionType)}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor) AllowedValues is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setType(ProductOptionType)}
   */
  @Test
  public void testSetType_givenProductOptionImplAllowedValuesIsArrayList_whenNull() {
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
   * Test {@link ProductOptionImpl#setType(ProductOptionType)}.
   * <ul>
   *   <li>When {@link ProductOptionType#BOOLEAN}.</li>
   *   <li>Then {@link ProductOptionImpl} (default constructor)
   * {@link ProductOptionImpl#type} is {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setType(ProductOptionType)}
   */
  @Test
  public void testSetType_whenBoolean_thenProductOptionImplTypeIsBoolean() {
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
   * Test {@link ProductOptionImpl#getLabel()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getLabel()}
   */
  @Test
  public void testGetLabel_givenProductOptionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getLabel());
  }

  /**
   * Test {@link ProductOptionImpl#getLabel()}.
   * <ul>
   *   <li>Given {@link ProductOptionType} {@link ProductOptionType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link ProductOptionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getLabel()}
   */
  @Test
  public void testGetLabel_givenProductOptionTypeGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link ProductOptionImpl#getProducts()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  public void testGetProducts() {
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
   * Test {@link ProductOptionImpl#getProducts()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  public void testGetProducts_givenProductOptionImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductOptionImpl()).getProducts().isEmpty());
  }

  /**
   * Test {@link ProductOptionImpl#getProducts()}.
   * <ul>
   *   <li>Then calls {@link ProductOptionValidationStrategyType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  public void testGetProducts_thenCallsGetType() {
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
   * Test {@link ProductOptionImpl#setProducts(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  public void testSetProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productOptionImpl.setProducts(products));
  }

  /**
   * Test {@link ProductOptionImpl#setProducts(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  public void testSetProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
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
   * Test {@link ProductOptionImpl#setProducts(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  public void testSetProducts_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productOptionImpl.setProducts(new ArrayList<>()));
  }

  /**
   * Test getters and setters.
   * <p>
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
   * Test {@link ProductOptionImpl#getUseInSkuGeneration()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  public void testGetUseInSkuGeneration() {
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
   * Test {@link ProductOptionImpl#getUseInSkuGeneration()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  public void testGetUseInSkuGeneration_givenProductOptionImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductOptionImpl()).getUseInSkuGeneration());
  }

  /**
   * Test {@link ProductOptionImpl#getUseInSkuGeneration()}.
   * <ul>
   *   <li>Then calls {@link ProductOptionValidationStrategyType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  public void testGetUseInSkuGeneration_thenCallsGetType() {
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
   * Test {@link ProductOptionImpl#getProductOptionValidationStrategyType()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionImpl#getProductOptionValidationStrategyType()}
   */
  @Test
  public void testGetProductOptionValidationStrategyType_givenProductOptionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getProductOptionValidationStrategyType());
  }

  /**
   * Test {@link ProductOptionImpl#getProductOptionValidationStrategyType()}.
   * <ul>
   *   <li>Then calls {@link ProductOptionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionImpl#getProductOptionValidationStrategyType()}
   */
  @Test
  public void testGetProductOptionValidationStrategyType_thenCallsGetType() {
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
   * Test
   * {@link ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}.
   * <p>
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
   * Test
   * {@link ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}.
   * <p>
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
   * Test {@link ProductOptionImpl#getProductOptionValidationType()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  public void testGetProductOptionValidationType() {
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
   * Test {@link ProductOptionImpl#getProductOptionValidationType()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  public void testGetProductOptionValidationType_givenProductOptionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductOptionValidationType actualProductOptionValidationType = (new ProductOptionImpl())
        .getProductOptionValidationType();

    // Assert
    assertSame(actualProductOptionValidationType.REGEX, actualProductOptionValidationType);
  }

  /**
   * Test {@link ProductOptionImpl#getProductOptionValidationType()}.
   * <ul>
   *   <li>Then calls {@link ProductOptionValidationStrategyType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  public void testGetProductOptionValidationType_thenCallsGetType() {
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
   * Test
   * {@link ProductOptionImpl#setProductOptionValidationType(ProductOptionValidationType)}.
   * <p>
   * Method under test:
   * {@link ProductOptionImpl#setProductOptionValidationType(ProductOptionValidationType)}
   */
  @Test
  public void testSetProductOptionValidationType() {
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
   * Test {@link ProductOptionImpl#getErrorMessage()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getErrorMessage()}
   */
  @Test
  public void testGetErrorMessage_givenProductOptionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getErrorMessage());
  }

  /**
   * Test {@link ProductOptionImpl#getErrorMessage()}.
   * <ul>
   *   <li>Given {@link ProductOptionType} {@link ProductOptionType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link ProductOptionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getErrorMessage()}
   */
  @Test
  public void testGetErrorMessage_givenProductOptionTypeGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link ProductOptionImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenProductOptionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getMainEntityName());
  }

  /**
   * Test {@link ProductOptionImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link ProductOptionType} {@link ProductOptionType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link ProductOptionType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenProductOptionTypeGetTypeReturnType_thenCallsGetType() {
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
   * Test
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
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
   * Test
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
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
   * Test
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link ProductOptionImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnProductOptionImpl() throws CloneNotSupportedException {
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
   * Test {@link ProductOptionImpl#equals(Object)}, and
   * {@link ProductOptionImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link ProductOptionImpl#equals(Object)}, and
   * {@link ProductOptionImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link ProductOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link ProductOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link ProductOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link ProductOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test new {@link ProductOptionImpl} (default constructor).
   * <p>
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
