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
import java.math.BigDecimal;
import java.util.HashMap;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryProductXrefImplDiffblueTest {
  @Autowired private CategoryProductXrefImpl categoryProductXrefImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#setCategory(Category)}
   *   <li>{@link CategoryProductXrefImpl#setDefaultReference(Boolean)}
   *   <li>{@link CategoryProductXrefImpl#setDisplayOrder(BigDecimal)}
   *   <li>{@link CategoryProductXrefImpl#setId(Long)}
   *   <li>{@link CategoryProductXrefImpl#setProduct(Product)}
   *   <li>{@link CategoryProductXrefImpl#getCategory()}
   *   <li>{@link CategoryProductXrefImpl#getDefaultReference()}
   *   <li>{@link CategoryProductXrefImpl#getDisplayOrder()}
   *   <li>{@link CategoryProductXrefImpl#getId()}
   *   <li>{@link CategoryProductXrefImpl#getProduct()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category CategoryProductXrefImpl.getCategory()",
    "Boolean CategoryProductXrefImpl.getDefaultReference()",
    "BigDecimal CategoryProductXrefImpl.getDisplayOrder()",
    "Long CategoryProductXrefImpl.getId()",
    "Product CategoryProductXrefImpl.getProduct()",
    "void CategoryProductXrefImpl.setCategory(Category)",
    "void CategoryProductXrefImpl.setDefaultReference(Boolean)",
    "void CategoryProductXrefImpl.setDisplayOrder(BigDecimal)",
    "void CategoryProductXrefImpl.setId(Long)",
    "void CategoryProductXrefImpl.setProduct(Product)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryProductXrefImpl.setCategory(category);
    categoryProductXrefImpl.setDefaultReference(true);
    BigDecimal displayOrder = new BigDecimal("2.3");
    categoryProductXrefImpl.setDisplayOrder(displayOrder);
    categoryProductXrefImpl.setId(1L);
    ProductBundleImpl product = new ProductBundleImpl();
    categoryProductXrefImpl.setProduct(product);
    Category actualCategory = categoryProductXrefImpl.getCategory();
    Boolean actualDefaultReference = categoryProductXrefImpl.getDefaultReference();
    BigDecimal actualDisplayOrder = categoryProductXrefImpl.getDisplayOrder();
    Long actualId = categoryProductXrefImpl.getId();
    Product actualProduct = categoryProductXrefImpl.getProduct();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertTrue(actualDefaultReference);
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
    assertSame(category, actualCategory);
    assertSame(product, actualProduct);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}, and {@link
   * CategoryProductXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#equals(Object)}
   *   <li>{@link CategoryProductXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
    assertEquals(categoryProductXrefImpl.hashCode(), categoryProductXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}, and {@link
   * CategoryProductXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#equals(Object)}
   *   <li>{@link CategoryProductXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(null);
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(null);
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
    assertEquals(categoryProductXrefImpl.hashCode(), categoryProductXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}, and {@link
   * CategoryProductXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#equals(Object)}
   *   <li>{@link CategoryProductXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(null);

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(null);

    // Act and Assert
    assertEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
    assertEquals(categoryProductXrefImpl.hashCode(), categoryProductXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}, and {@link
   * CategoryProductXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryProductXrefImpl#equals(Object)}
   *   <li>{@link CategoryProductXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertEquals(categoryProductXrefImpl, categoryProductXrefImpl);
    int expectedHashCodeResult = categoryProductXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryProductXrefImpl.hashCode());
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(null);
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(mock(CategoryImpl.class));
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(product);

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(null);

    CategoryProductXrefImpl categoryProductXrefImpl2 = new CategoryProductXrefImpl();
    categoryProductXrefImpl2.setCategory(new CategoryImpl());
    categoryProductXrefImpl2.setDefaultReference(true);
    categoryProductXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl2.setId(1L);
    categoryProductXrefImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, categoryProductXrefImpl2);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, null);
  }

  /**
   * Test {@link CategoryProductXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryProductXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryProductXrefImpl.equals(Object)",
    "int CategoryProductXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    categoryProductXrefImpl.setCategory(new CategoryImpl());
    categoryProductXrefImpl.setDefaultReference(true);
    categoryProductXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryProductXrefImpl.setId(1L);
    categoryProductXrefImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNotEquals(categoryProductXrefImpl, "Different type to CategoryProductXrefImpl");
  }

  /**
   * Test {@link CategoryProductXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryProductXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryProductXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new CategoryProductXrefImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryProductXref> actualCreateOrRetrieveCopyInstanceResult =
        categoryProductXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryProductXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryProductXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryProductXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>(categoryProductXrefImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryProductXref> actualCreateOrRetrieveCopyInstanceResult =
        categoryProductXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link CategoryProductXrefImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CategoryProductXrefImpl}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryProductXrefImpl.<init>()"})
  public void testNewCategoryProductXrefImpl() {
    // Arrange and Act
    CategoryProductXrefImpl actualCategoryProductXrefImpl = new CategoryProductXrefImpl();

    // Assert
    assertTrue(actualCategoryProductXrefImpl.getCategory() instanceof CategoryImpl);
    assertTrue(actualCategoryProductXrefImpl.getProduct() instanceof ProductImpl);
    assertNull(actualCategoryProductXrefImpl.getDefaultReference());
    assertNull(actualCategoryProductXrefImpl.getId());
    assertNull(actualCategoryProductXrefImpl.getDisplayOrder());
  }
}
