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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
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
public class CrossSaleProductImplDiffblueTest {
  @Autowired
  private CrossSaleProductImpl crossSaleProductImpl;

  /**
   * Test {@link CrossSaleProductImpl#getPromotionMessage()}.
   * <p>
   * Method under test: {@link CrossSaleProductImpl#getPromotionMessage()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CrossSaleProductImpl.getPromotionMessage()"})
  public void testGetPromotionMessage() {
    // Arrange, Act and Assert
    assertNull((new CrossSaleProductImpl()).getPromotionMessage());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CrossSaleProductImpl#setCategory(Category)}
   *   <li>{@link CrossSaleProductImpl#setId(Long)}
   *   <li>{@link CrossSaleProductImpl#setProduct(Product)}
   *   <li>{@link CrossSaleProductImpl#setPromotionMessage(String)}
   *   <li>{@link CrossSaleProductImpl#setRelatedProduct(Product)}
   *   <li>{@link CrossSaleProductImpl#setSequence(BigDecimal)}
   *   <li>{@link CrossSaleProductImpl#getCategory()}
   *   <li>{@link CrossSaleProductImpl#getId()}
   *   <li>{@link CrossSaleProductImpl#getProduct()}
   *   <li>{@link CrossSaleProductImpl#getRelatedProduct()}
   *   <li>{@link CrossSaleProductImpl#getSequence()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Category CrossSaleProductImpl.getCategory()", "Long CrossSaleProductImpl.getId()",
      "Product CrossSaleProductImpl.getProduct()", "Product CrossSaleProductImpl.getRelatedProduct()",
      "BigDecimal CrossSaleProductImpl.getSequence()", "void CrossSaleProductImpl.setCategory(Category)",
      "void CrossSaleProductImpl.setId(Long)", "void CrossSaleProductImpl.setProduct(Product)",
      "void CrossSaleProductImpl.setPromotionMessage(String)", "void CrossSaleProductImpl.setRelatedProduct(Product)",
      "void CrossSaleProductImpl.setSequence(BigDecimal)"})
  public void testGettersAndSetters() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    crossSaleProductImpl.setCategory(category);
    crossSaleProductImpl.setId(1L);
    ProductBundleImpl product = new ProductBundleImpl();
    crossSaleProductImpl.setProduct(product);
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    ProductBundleImpl relatedSaleProduct = new ProductBundleImpl();
    crossSaleProductImpl.setRelatedProduct(relatedSaleProduct);
    BigDecimal sequence = new BigDecimal("2.3");
    crossSaleProductImpl.setSequence(sequence);
    Category actualCategory = crossSaleProductImpl.getCategory();
    Long actualId = crossSaleProductImpl.getId();
    Product actualProduct = crossSaleProductImpl.getProduct();
    Product actualRelatedProduct = crossSaleProductImpl.getRelatedProduct();
    BigDecimal actualSequence = crossSaleProductImpl.getSequence();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(product, actualProduct);
    assertSame(relatedSaleProduct, actualRelatedProduct);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}, and {@link CrossSaleProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CrossSaleProductImpl#equals(Object)}
   *   <li>{@link CrossSaleProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(crossSaleProductImpl, crossSaleProductImpl2);
    int expectedHashCodeResult = crossSaleProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, crossSaleProductImpl2.hashCode());
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}, and {@link CrossSaleProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CrossSaleProductImpl#equals(Object)}
   *   <li>{@link CrossSaleProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(null);
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(null);
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(crossSaleProductImpl, crossSaleProductImpl2);
    int expectedHashCodeResult = crossSaleProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, crossSaleProductImpl2.hashCode());
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}, and {@link CrossSaleProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CrossSaleProductImpl#equals(Object)}
   *   <li>{@link CrossSaleProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(crossSaleProductImpl, crossSaleProductImpl);
    int expectedHashCodeResult = crossSaleProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, crossSaleProductImpl.hashCode());
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(null);
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(mock(CategoryImpl.class));
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(product);
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(null);
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage(null);
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("42");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductBundleImpl relatedSaleProduct = new ProductBundleImpl();
    relatedSaleProduct.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(relatedSaleProduct);
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(null);
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("4.5"));

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(null);

    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    crossSaleProductImpl2.setCategory(new CategoryImpl());
    crossSaleProductImpl2.setId(1L);
    crossSaleProductImpl2.setProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setPromotionMessage("Promotion Message");
    crossSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, crossSaleProductImpl2);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, null);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CrossSaleProductImpl.equals(Object)", "int CrossSaleProductImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setCategory(new CategoryImpl());
    crossSaleProductImpl.setId(1L);
    crossSaleProductImpl.setProduct(new ProductBundleImpl());
    crossSaleProductImpl.setPromotionMessage("Promotion Message");
    crossSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    crossSaleProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(crossSaleProductImpl, "Different type to CrossSaleProductImpl");
  }

  /**
   * Test {@link CrossSaleProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link CrossSaleProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse CrossSaleProductImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CrossSaleProductImpl crossSaleProductImpl2 = new CrossSaleProductImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CrossSaleProductImpl> actualCreateOrRetrieveCopyInstanceResult = crossSaleProductImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link CrossSaleProductImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CrossSaleProductImpl}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CrossSaleProductImpl.<init>()"})
  public void testNewCrossSaleProductImpl() {
    // Arrange and Act
    CrossSaleProductImpl actualCrossSaleProductImpl = new CrossSaleProductImpl();

    // Assert
    assertTrue(actualCrossSaleProductImpl.getRelatedProduct() instanceof ProductImpl);
    assertNull(actualCrossSaleProductImpl.getId());
    assertNull(actualCrossSaleProductImpl.getPromotionMessage());
    assertNull(actualCrossSaleProductImpl.promotionMessage);
    assertNull(actualCrossSaleProductImpl.getSequence());
    assertNull(actualCrossSaleProductImpl.getCategory());
    assertNull(actualCrossSaleProductImpl.getProduct());
  }
}
