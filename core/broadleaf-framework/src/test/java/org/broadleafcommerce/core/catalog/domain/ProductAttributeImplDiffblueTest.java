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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
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
public class ProductAttributeImplDiffblueTest {
  @Autowired private ProductAttributeImpl productAttributeImpl;

  /**
   * Test {@link ProductAttributeImpl#getValue()}.
   *
   * <p>Method under test: {@link ProductAttributeImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductAttributeImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull(productAttributeImpl.getValue());
  }

  /**
   * Test {@link ProductAttributeImpl#getName()}.
   *
   * <p>Method under test: {@link ProductAttributeImpl#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductAttributeImpl.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(productAttributeImpl.getName());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(null);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName(null);
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName(null);
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(null);
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(null);
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue(null);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue(null);

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    assertEquals(productAttributeImpl.hashCode(), productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and {@link ProductAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl);
    int expectedHashCodeResult = productAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, productAttributeImpl.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(2L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("42");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName(null);
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(product);
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(null);
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("Name");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue(null);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, null);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductAttributeImpl.equals(Object)",
    "int ProductAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, "Different type to ProductAttributeImpl");
  }

  /**
   * Test {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new ProductAttributeImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductAttribute> actualCreateOrRetrieveCopyInstanceResult =
        productAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(productAttributeImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductAttribute> actualCreateOrRetrieveCopyInstanceResult =
        productAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new ProductBundleImpl(), true));

    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setProduct(product);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");
    CreateResponse<Object> createResponse = new CreateResponse<>(productAttributeImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductAttribute> actualCreateOrRetrieveCopyInstanceResult =
        productAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(product).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setProduct(product);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(productAttributeImpl2, false));

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> productAttributeImpl.createOrRetrieveCopyInstance(context));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(product).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ProductAttributeImpl}
   *   <li>{@link ProductAttributeImpl#setId(Long)}
   *   <li>{@link ProductAttributeImpl#setName(String)}
   *   <li>{@link ProductAttributeImpl#setProduct(Product)}
   *   <li>{@link ProductAttributeImpl#setValue(String)}
   *   <li>{@link ProductAttributeImpl#getId()}
   *   <li>{@link ProductAttributeImpl#getProduct()}
   *   <li>{@link ProductAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductAttributeImpl.<init>()",
    "Long ProductAttributeImpl.getId()",
    "Product ProductAttributeImpl.getProduct()",
    "void ProductAttributeImpl.setId(Long)",
    "void ProductAttributeImpl.setName(String)",
    "void ProductAttributeImpl.setProduct(Product)",
    "void ProductAttributeImpl.setValue(String)",
    "String ProductAttributeImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductAttributeImpl actualProductAttributeImpl = new ProductAttributeImpl();
    actualProductAttributeImpl.setId(1L);
    actualProductAttributeImpl.setName("Name");
    ProductBundleImpl product = new ProductBundleImpl();
    actualProductAttributeImpl.setProduct(product);
    actualProductAttributeImpl.setValue("42");
    Long actualId = actualProductAttributeImpl.getId();
    Product actualProduct = actualProductAttributeImpl.getProduct();

    // Assert
    assertEquals("42", actualProductAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(product, actualProduct);
  }
}
