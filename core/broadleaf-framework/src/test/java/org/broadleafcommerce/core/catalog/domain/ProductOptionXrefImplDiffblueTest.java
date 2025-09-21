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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionXrefImplDiffblueTest {
  @Autowired private ProductOptionXrefImpl productOptionXrefImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ProductOptionXrefImpl.getId()",
    "Product ProductOptionXrefImpl.getProduct()",
    "ProductOption ProductOptionXrefImpl.getProductOption()",
    "void ProductOptionXrefImpl.setId(Long)",
    "void ProductOptionXrefImpl.setProduct(Product)",
    "void ProductOptionXrefImpl.setProductOption(ProductOption)"
  })
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

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(product, actualProduct);
    assertSame(productOption, actualProductOption);
  }

  /**
   * Test {@link ProductOptionXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new ProductOptionXrefImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionXref> actualCreateOrRetrieveCopyInstanceResult =
        productOptionXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductOptionXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductOptionXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>(productOptionXrefImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionXref> actualCreateOrRetrieveCopyInstanceResult =
        productOptionXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionXrefImpl#equals(Object)}, and {@link
   * ProductOptionXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionXrefImpl#equals(Object)}
   *   <li>{@link ProductOptionXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionXrefImpl.equals(Object)",
    "int ProductOptionXrefImpl.hashCode()"
  })
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
    assertEquals(productOptionXrefImpl.hashCode(), productOptionXrefImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionXrefImpl#equals(Object)}, and {@link
   * ProductOptionXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionXrefImpl#equals(Object)}
   *   <li>{@link ProductOptionXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionXrefImpl.equals(Object)",
    "int ProductOptionXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionXrefImpl.equals(Object)",
    "int ProductOptionXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionXrefImpl.equals(Object)",
    "int ProductOptionXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionXrefImpl.equals(Object)",
    "int ProductOptionXrefImpl.hashCode()"
  })
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
   *
   * <p>Method under test: default or parameterless constructor of {@link ProductOptionXrefImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionXrefImpl.<init>()"})
  public void testNewProductOptionXrefImpl() {
    // Arrange and Act
    ProductOptionXrefImpl actualProductOptionXrefImpl = new ProductOptionXrefImpl();

    // Assert
    assertTrue(actualProductOptionXrefImpl.getProduct() instanceof ProductImpl);
    assertTrue(actualProductOptionXrefImpl.getProductOption() instanceof ProductOptionImpl);
    assertNull(actualProductOptionXrefImpl.getId());
  }
}
