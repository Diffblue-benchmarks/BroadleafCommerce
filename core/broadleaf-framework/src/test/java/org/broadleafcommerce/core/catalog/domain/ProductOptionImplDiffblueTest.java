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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductOptionImplDiffblueTest {
  @Autowired
  private ProductOptionImpl productOptionImpl;

  /**
   * Test {@link ProductOptionImpl#getName()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor) Name is empty string.</li>
   *   <li>Then return {@code Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductOptionImpl.getName()"})
  public void testGetName_givenProductOptionImplNameIsEmptyString_thenReturnLabel() {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");
    productOptionImpl2.setName("");

    // Act and Assert
    assertEquals("Label", productOptionImpl2.getName());
  }

  /**
   * Test {@link ProductOptionImpl#getName()}.
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor) Name is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductOptionImpl.getName()"})
  public void testGetName_givenProductOptionImplNameIsFoo_thenReturnFoo() {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");
    productOptionImpl2.setName("foo");

    // Act and Assert
    assertEquals("foo", productOptionImpl2.getName());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductOptionImpl.getName()"})
  public void testGetName_givenProductOptionImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getName());
  }

  /**
   * Test {@link ProductOptionImpl#getType()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductOptionType ProductOptionImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getType());
  }

  /**
   * Test {@link ProductOptionImpl#setType(ProductOptionType)}.
   * <ul>
   *   <li>Then {@link ProductOptionImpl} (default constructor) {@link ProductOptionImpl#type} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setType(ProductOptionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionImpl.setType(ProductOptionType)"})
  public void testSetType_thenProductOptionImplTypeIsNull() {
    // Arrange
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

    // Act
    productOptionImpl2.setType(null);

    // Assert
    assertNull(productOptionImpl2.type);
    assertNull(productOptionImpl2.getType());
  }

  /**
   * Test {@link ProductOptionImpl#setType(ProductOptionType)}.
   * <ul>
   *   <li>When {@link ProductOptionType#BOOLEAN}.</li>
   *   <li>Then {@link ProductOptionImpl} (default constructor) {@link ProductOptionImpl#type} is {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setType(ProductOptionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionImpl.setType(ProductOptionType)"})
  public void testSetType_whenBoolean_thenProductOptionImplTypeIsBoolean() {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    ProductOptionType type = ProductOptionType.BOOLEAN;

    // Act
    productOptionImpl2.setType(type);

    // Assert
    assertEquals("BOOLEAN", productOptionImpl2.type);
    ProductOptionType expectedType = type.BOOLEAN;
    assertSame(expectedType, productOptionImpl2.getType());
  }

  /**
   * Test {@link ProductOptionImpl#getLabel()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getLabel()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductOptionImpl.getLabel()"})
  public void testGetLabel() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getLabel());
  }

  /**
   * Test {@link ProductOptionImpl#getProducts()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductOptionXrefImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getProducts()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductOptionImpl.getProducts()"})
  public void testGetProducts_givenArrayListAddProductOptionXrefImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<ProductOptionXref> xrefs = new ArrayList<>();
    xrefs.add(new ProductOptionXrefImpl());

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
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");
    productOptionImpl2.setProductXrefs(xrefs);

    // Act
    List<Product> actualProducts = productOptionImpl2.getProducts();

    // Assert
    assertEquals(1, actualProducts.size());
    assertTrue(actualProducts.get(0) instanceof ProductImpl);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductOptionImpl.getProducts()"})
  public void testGetProducts_givenProductOptionImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ProductOptionImpl()).getProducts().isEmpty());
  }

  /**
   * Test {@link ProductOptionImpl#setProducts(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionImpl.setProducts(List)"})
  public void testSetProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productOptionImpl2.setProducts(products));
  }

  /**
   * Test {@link ProductOptionImpl#setProducts(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#setProducts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionImpl.setProducts(List)"})
  public void testSetProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productOptionImpl2.setProducts(products));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionImpl.setProducts(List)"})
  public void testSetProducts_whenArrayList() {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productOptionImpl2.setProducts(new ArrayList<>()));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ProductOptionImpl.getAllowedValues()", "String ProductOptionImpl.getAttributeName()",
      "Integer ProductOptionImpl.getDisplayOrder()", "String ProductOptionImpl.getErrorCode()",
      "Long ProductOptionImpl.getId()", "List ProductOptionImpl.getProductXrefs()",
      "Boolean ProductOptionImpl.getRequired()", "String ProductOptionImpl.getValidationString()",
      "void ProductOptionImpl.setAllowedValues(List)", "void ProductOptionImpl.setAttributeName(String)",
      "void ProductOptionImpl.setDisplayOrder(Integer)", "void ProductOptionImpl.setErrorCode(String)",
      "void ProductOptionImpl.setErrorMessage(String)", "void ProductOptionImpl.setId(Long)",
      "void ProductOptionImpl.setLabel(String)", "void ProductOptionImpl.setName(String)",
      "void ProductOptionImpl.setProductXrefs(List)", "void ProductOptionImpl.setRequired(Boolean)",
      "void ProductOptionImpl.setUseInSkuGeneration(Boolean)", "void ProductOptionImpl.setValidationString(String)"})
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
   * <ul>
   *   <li>Given {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductOptionImpl.getUseInSkuGeneration()"})
  public void testGetUseInSkuGeneration_givenProductOptionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ProductOptionImpl()).getUseInSkuGeneration());
  }

  /**
   * Test {@link ProductOptionImpl#getUseInSkuGeneration()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#getUseInSkuGeneration()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductOptionImpl.getUseInSkuGeneration()"})
  public void testGetUseInSkuGeneration_thenReturnTrue() {
    // Arrange
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
    productOptionImpl2.setValidationString("Validation String");
    productOptionImpl2.setUseInSkuGeneration(null);

    // Act and Assert
    assertTrue(productOptionImpl2.getUseInSkuGeneration());
  }

  /**
   * Test {@link ProductOptionImpl#getProductOptionValidationStrategyType()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getProductOptionValidationStrategyType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductOptionValidationStrategyType ProductOptionImpl.getProductOptionValidationStrategyType()"})
  public void testGetProductOptionValidationStrategyType() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getProductOptionValidationStrategyType());
  }

  /**
   * Test {@link ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}.
   * <p>
   * Method under test: {@link ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ProductOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)"})
  public void testSetProductOptionValidationStrategyType() {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    ProductOptionValidationStrategyType productOptionValidationStrategyType = ProductOptionValidationStrategyType.ADD_ITEM;

    // Act
    productOptionImpl2.setProductOptionValidationStrategyType(productOptionValidationStrategyType);

    // Assert
    ProductOptionValidationStrategyType expectedProductOptionValidationStrategyType = productOptionValidationStrategyType.ADD_ITEM;
    assertSame(expectedProductOptionValidationStrategyType,
        productOptionImpl2.getProductOptionValidationStrategyType());
  }

  /**
   * Test {@link ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}.
   * <p>
   * Method under test: {@link ProductOptionImpl#setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ProductOptionImpl.setProductOptionValidationStrategyType(ProductOptionValidationStrategyType)"})
  public void testSetProductOptionValidationStrategyType2() {
    // Arrange
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

    // Act
    productOptionImpl2.setProductOptionValidationStrategyType(null);

    // Assert
    assertNull(productOptionImpl2.getProductOptionValidationStrategyType());
  }

  /**
   * Test {@link ProductOptionImpl#getProductOptionValidationType()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getProductOptionValidationType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductOptionValidationType ProductOptionImpl.getProductOptionValidationType()"})
  public void testGetProductOptionValidationType() {
    // Arrange
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
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);

    // Act
    ProductOptionValidationType actualProductOptionValidationType = productOptionImpl2.getProductOptionValidationType();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductOptionValidationType ProductOptionImpl.getProductOptionValidationType()"})
  public void testGetProductOptionValidationType_givenProductOptionImpl() {
    // Arrange and Act
    ProductOptionValidationType actualProductOptionValidationType = (new ProductOptionImpl())
        .getProductOptionValidationType();

    // Assert
    assertSame(actualProductOptionValidationType.REGEX, actualProductOptionValidationType);
  }

  /**
   * Test {@link ProductOptionImpl#setProductOptionValidationType(ProductOptionValidationType)}.
   * <p>
   * Method under test: {@link ProductOptionImpl#setProductOptionValidationType(ProductOptionValidationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionImpl.setProductOptionValidationType(ProductOptionValidationType)"})
  public void testSetProductOptionValidationType() {
    // Arrange
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

    // Act
    productOptionImpl2.setProductOptionValidationType(null);

    // Assert that nothing has changed
    ProductOptionValidationType productOptionValidationType = productOptionImpl2.getProductOptionValidationType();
    assertEquals("REGEX", productOptionValidationType.getType());
    assertEquals("Regular Expression", productOptionValidationType.getFriendlyType());
  }

  /**
   * Test {@link ProductOptionImpl#getErrorMessage()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getErrorMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductOptionImpl.getErrorMessage()"})
  public void testGetErrorMessage() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getErrorMessage());
  }

  /**
   * Test {@link ProductOptionImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link ProductOptionImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductOptionImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionImpl()).getMainEntityName());
  }

  /**
   * Test {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse ProductOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult = productOptionImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link ProductOptionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse ProductOptionImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnProductOptionImpl() throws CloneNotSupportedException {
    // Arrange
    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<ProductOption> actualCreateOrRetrieveCopyInstanceResult = productOptionImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.ProductOptionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    assertTrue(actualCreateOrRetrieveCopyInstanceResult.getClone() instanceof ProductOptionImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Test {@link ProductOptionImpl#equals(Object)}, and {@link ProductOptionImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionImpl.equals(Object)", "int ProductOptionImpl.hashCode()"})
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
   * Test {@link ProductOptionImpl#equals(Object)}, and {@link ProductOptionImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionImpl.equals(Object)", "int ProductOptionImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionImpl.equals(Object)", "int ProductOptionImpl.hashCode()"})
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
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionImpl.equals(Object)", "int ProductOptionImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionImpl.equals(Object)", "int ProductOptionImpl.hashCode()"})
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
   * Method under test: default or parameterless constructor of {@link ProductOptionImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
