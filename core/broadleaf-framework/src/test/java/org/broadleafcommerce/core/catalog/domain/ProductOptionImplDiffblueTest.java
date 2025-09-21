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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.catalog.domain.CategoryAdminPresentation.GroupOrder;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationStrategyType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionImplDiffblueTest {
  @Autowired private ProductOptionImpl productOptionImpl;

  /**
   * Test {@link ProductOptionImpl#getName()}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionImpl} Name is empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionImpl.getName()"})
  public void testGetName_givenProductOptionImplNameIsEmptyString_thenReturnNull() {
    // Arrange
    productOptionImpl.setName("");

    // Act and Assert
    assertNull(productOptionImpl.getName());
  }

  /**
   * Test {@link ProductOptionImpl#getName()}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionImpl} Name is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionImpl.getName()"})
  public void testGetName_givenProductOptionImplNameIsFoo_thenReturnFoo() {
    // Arrange
    productOptionImpl.setName("foo");

    // Act and Assert
    assertEquals("foo", productOptionImpl.getName());
  }

  /**
   * Test {@link ProductOptionImpl#getName()}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionImpl.getName()"})
  public void testGetName_givenProductOptionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productOptionImpl.getName());
  }

  /**
   * Test {@link ProductOptionImpl#getType()}.
   *
   * <p>Method under test: {@link ProductOptionImpl#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProductOptionType ProductOptionImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(productOptionImpl.getType());
  }

  /**
   * Test {@link ProductOptionImpl#setType(ProductOptionType)}.
   *
   * <ul>
   *   <li>When {@link ProductOptionType#BOOLEAN}.
   *   <li>Then {@link ProductOptionImpl} {@link ProductOptionImpl#type} is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#setType(ProductOptionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionImpl.setType(ProductOptionType)"})
  public void testSetType_whenBoolean_thenProductOptionImplTypeIsBoolean() {
    // Arrange and Act
    productOptionImpl.setType(ProductOptionType.BOOLEAN);

    // Assert
    assertEquals("BOOLEAN", productOptionImpl.type);
    assertSame(ProductOptionType.BOOLEAN, productOptionImpl.getType());
  }

  /**
   * Test {@link ProductOptionImpl#setType(ProductOptionType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ProductOptionImpl} {@link ProductOptionImpl#type} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#setType(ProductOptionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionImpl.setType(ProductOptionType)"})
  public void testSetType_whenNull_thenProductOptionImplTypeIsNull() {
    // Arrange and Act
    productOptionImpl.setType(null);

    // Assert that nothing has changed
    assertNull(productOptionImpl.type);
    assertNull(productOptionImpl.getType());
  }

  /**
   * Test {@link ProductOptionImpl#getLabel()}.
   *
   * <p>Method under test: {@link ProductOptionImpl#getLabel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionImpl.getLabel()"})
  public void testGetLabel() {
    // Arrange, Act and Assert
    assertNull(productOptionImpl.getLabel());
  }

  /**
   * Test {@link ProductOptionImpl#getProducts()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductOptionXrefImpl} (default
   *       constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductOptionImpl.getProducts()"})
  public void testGetProducts_givenArrayListAddProductOptionXrefImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<ProductOptionXref> xrefs = new ArrayList<>();
    xrefs.add(new ProductOptionXrefImpl());
    productOptionImpl.setProductXrefs(xrefs);

    // Act
    List<Product> actualProducts = productOptionImpl.getProducts();

    // Assert
    assertEquals(1, actualProducts.size());
    assertTrue(actualProducts.get(0) instanceof ProductImpl);
  }

  /**
   * Test {@link ProductOptionImpl#getProducts()}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductOptionImpl.getProducts()"})
  public void testGetProducts_givenProductOptionImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(productOptionImpl.getProducts().isEmpty());
  }

  /**
   * Test {@link ProductOptionImpl#setProducts(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionImpl.setProducts(List)"})
  public void testSetProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    // Arrange
    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> productOptionImpl.setProducts(products));
  }

  /**
   * Test {@link ProductOptionImpl#setProducts(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionImpl.setProducts(List)"})
  public void testSetProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    // Arrange
    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> productOptionImpl.setProducts(products));
  }

  /**
   * Test {@link ProductOptionImpl#setProducts(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionImpl.setProducts(List)"})
  public void testSetProducts_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> productOptionImpl.setProducts(new ArrayList<>()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ProductOptionImpl.getAllowedValues()",
    "String ProductOptionImpl.getAttributeName()",
    "Integer ProductOptionImpl.getDisplayOrder()",
    "String ProductOptionImpl.getErrorCode()",
    "Long ProductOptionImpl.getId()",
    "List ProductOptionImpl.getProductXrefs()",
    "Boolean ProductOptionImpl.getRequired()",
    "String ProductOptionImpl.getValidationString()",
    "void ProductOptionImpl.setAllowedValues(List)",
    "void ProductOptionImpl.setAttributeName(String)",
    "void ProductOptionImpl.setDisplayOrder(Integer)",
    "void ProductOptionImpl.setErrorCode(String)",
    "void ProductOptionImpl.setErrorMessage(String)",
    "void ProductOptionImpl.setId(Long)",
    "void ProductOptionImpl.setLabel(String)",
    "void ProductOptionImpl.setName(String)",
    "void ProductOptionImpl.setProductXrefs(List)",
    "void ProductOptionImpl.setRequired(Boolean)",
    "void ProductOptionImpl.setUseInSkuGeneration(Boolean)",
    "void ProductOptionImpl.setValidationString(String)"
  })
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

    // Assert
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
   *
   * <ul>
   *   <li>Given {@link ProductOptionImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionImpl.getUseInSkuGeneration()"})
  public void testGetUseInSkuGeneration_givenProductOptionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productOptionImpl.getUseInSkuGeneration());
  }

  /**
   * Test {@link ProductOptionImpl#getUseInSkuGeneration()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductOptionImpl.getUseInSkuGeneration()"})
  public void testGetUseInSkuGeneration_thenReturnTrue() {
    // Arrange
    productOptionImpl.setUseInSkuGeneration(null);

    // Act and Assert
    assertTrue(productOptionImpl.getUseInSkuGeneration());
  }

  /**
   * Test {@link ProductOptionImpl#getProductOptionValidationStrategyType()}.
   *
   * <p>Method under test: {@link ProductOptionImpl#getProductOptionValidationStrategyType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionValidationStrategyType ProductOptionImpl.getProductOptionValidationStrategyType()"
  })
  public void testGetProductOptionValidationStrategyType() {
    // Arrange, Act and Assert
    assertNull(productOptionImpl.getProductOptionValidationStrategyType());
  }

  /**
   * Test {@link
   * ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}.
   *
   * <p>Method under test: {@link
   * ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)"
  })
  public void testSetProductOptionValidationStrategyType() {
    // Arrange and Act
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);

    // Assert
    assertSame(
        ProductOptionValidationStrategyType.ADD_ITEM,
        productOptionImpl.getProductOptionValidationStrategyType());
  }

  /**
   * Test {@link
   * ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}.
   *
   * <p>Method under test: {@link
   * ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)"
  })
  public void testSetProductOptionValidationStrategyType2() {
    // Arrange and Act
    productOptionImpl.setProductOptionValidationStrategyType(null);

    // Assert that nothing has changed
    assertNull(productOptionImpl.getProductOptionValidationStrategyType());
  }

  /**
   * Test {@link ProductOptionImpl#getProductOptionValidationType()}.
   *
   * <p>Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionValidationType ProductOptionImpl.getProductOptionValidationType()"
  })
  public void testGetProductOptionValidationType() {
    // Arrange
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);

    // Act and Assert
    assertSame(
        ProductOptionValidationType.REGEX, productOptionImpl.getProductOptionValidationType());
  }

  /**
   * Test {@link ProductOptionImpl#getProductOptionValidationType()}.
   *
   * <p>Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionValidationType ProductOptionImpl.getProductOptionValidationType()"
  })
  public void testGetProductOptionValidationType2() {
    // Arrange
    productOptionImpl.setProductOptionValidationType(
        new ProductOptionValidationType("", "Friendly Type"));

    // Act and Assert
    assertSame(
        ProductOptionValidationType.REGEX, productOptionImpl.getProductOptionValidationType());
  }

  /**
   * Test {@link ProductOptionImpl#getProductOptionValidationType()}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionValidationType ProductOptionImpl.getProductOptionValidationType()"
  })
  public void testGetProductOptionValidationType_givenProductOptionImpl() {
    // Arrange, Act and Assert
    assertSame(
        ProductOptionValidationType.REGEX, productOptionImpl.getProductOptionValidationType());
  }

  /**
   * Test {@link ProductOptionImpl#setProductOptionValidationType(ProductOptionValidationType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionImpl#setProductOptionValidationType(ProductOptionValidationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionImpl.setProductOptionValidationType(ProductOptionValidationType)"
  })
  public void testSetProductOptionValidationType_whenNull() {
    // Arrange and Act
    productOptionImpl.setProductOptionValidationType(null);

    // Assert that nothing has changed
    ProductOptionValidationType productOptionValidationType =
        productOptionImpl.getProductOptionValidationType();
    assertEquals("REGEX", productOptionValidationType.getType());
    assertEquals("Regular Expression", productOptionValidationType.getFriendlyType());
  }

  /**
   * Test {@link ProductOptionImpl#getErrorMessage()}.
   *
   * <p>Method under test: {@link ProductOptionImpl#getErrorMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionImpl.getErrorMessage()"})
  public void testGetErrorMessage() {
    // Arrange, Act and Assert
    assertNull(productOptionImpl.getErrorMessage());
  }

  /**
   * Test {@link ProductOptionImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link ProductOptionImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(productOptionImpl.getMainEntityName());
  }

  /**
   * Test {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new ProductOptionImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult =
        productOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(productOptionImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult =
        productOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(productOptionImpl2, false));

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult =
        productOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    ProductOption clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof ProductOptionImpl);
    ProductOptionValidationStrategyType productOptionValidationStrategyType =
        clone.getProductOptionValidationStrategyType();
    assertEquals("ADD_ITEM", productOptionValidationStrategyType.getType());
    assertEquals("Validate On Add Item", productOptionValidationStrategyType.getFriendlyType());
    assertNull(((ProductOptionImpl) clone).type);
    assertNull(clone.getType());
    assertEquals(
        GroupOrder.Miscellaneous, productOptionValidationStrategyType.getRank().intValue());
  }

  /**
   * Test {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");
    CreateResponse<Object> createResponse = new CreateResponse<>(productOptionImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult =
        productOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then return Clone Type Type is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenReturnCloneTypeTypeIsBoolean()
      throws CloneNotSupportedException {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setType(ProductOptionType.BOOLEAN);

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(productOptionImpl2, false));

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult =
        productOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    ProductOption clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof ProductOptionImpl);
    ProductOptionType type = clone.getType();
    assertEquals("BOOLEAN", type.getType());
    assertEquals("BOOLEAN", ((ProductOptionImpl) clone).type);
    assertEquals("Boolean", type.getFriendlyType());
    assertNull(clone.getProductOptionValidationStrategyType());
  }

  /**
   * Test {@link ProductOptionImpl#equals(Object)}, and {@link ProductOptionImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionImpl#equals(Object)}
   *   <li>{@link ProductOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
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
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
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
    productOptionImpl2.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");

    // Act and Assert
    assertEquals(productOptionImpl, productOptionImpl2);
    assertEquals(productOptionImpl.hashCode(), productOptionImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionImpl#equals(Object)}, and {@link ProductOptionImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionImpl#equals(Object)}
   *   <li>{@link ProductOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
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
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
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
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
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
    productOptionImpl2.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
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
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
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
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
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
   *
   * <p>Method under test: default or parameterless constructor of {@link ProductOptionImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionImpl.<init>()"})
  public void testNewProductOptionImpl() {
    // Arrange and Act
    ProductOptionImpl actualProductOptionImpl = new ProductOptionImpl();

    // Assert
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
