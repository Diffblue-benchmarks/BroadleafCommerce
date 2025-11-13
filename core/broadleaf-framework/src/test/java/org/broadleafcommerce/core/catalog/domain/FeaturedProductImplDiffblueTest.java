package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.junit.Test;

public class FeaturedProductImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FeaturedProductImpl#setCategory(Category)}
   *   <li>{@link FeaturedProductImpl#setId(Long)}
   *   <li>{@link FeaturedProductImpl#setProduct(Product)}
   *   <li>{@link FeaturedProductImpl#setPromotionMessage(String)}
   *   <li>{@link FeaturedProductImpl#setSequence(BigDecimal)}
   *   <li>{@link FeaturedProductImpl#getCategory()}
   *   <li>{@link FeaturedProductImpl#getId()}
   *   <li>{@link FeaturedProductImpl#getProduct()}
   *   <li>{@link FeaturedProductImpl#getPromotionMessage()}
   *   <li>{@link FeaturedProductImpl#getRelatedProduct()}
   *   <li>{@link FeaturedProductImpl#getSequence()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category FeaturedProductImpl.getCategory()",
    "Long FeaturedProductImpl.getId()",
    "Product FeaturedProductImpl.getProduct()",
    "String FeaturedProductImpl.getPromotionMessage()",
    "Product FeaturedProductImpl.getRelatedProduct()",
    "BigDecimal FeaturedProductImpl.getSequence()",
    "void FeaturedProductImpl.setCategory(Category)",
    "void FeaturedProductImpl.setId(Long)",
    "void FeaturedProductImpl.setProduct(Product)",
    "void FeaturedProductImpl.setPromotionMessage(String)",
    "void FeaturedProductImpl.setSequence(BigDecimal)"
  })
  public void testGettersAndSetters() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    featuredProductImpl.setCategory(category);
    featuredProductImpl.setId(1L);
    ProductBundleImpl product = new ProductBundleImpl();
    featuredProductImpl.setProduct(product);
    featuredProductImpl.setPromotionMessage("Promotion Message");
    BigDecimal sequence = new BigDecimal("2.3");
    featuredProductImpl.setSequence(sequence);
    Category actualCategory = featuredProductImpl.getCategory();
    Long actualId = featuredProductImpl.getId();
    Product actualProduct = featuredProductImpl.getProduct();
    String actualPromotionMessage = featuredProductImpl.getPromotionMessage();
    Product actualRelatedProduct = featuredProductImpl.getRelatedProduct();
    BigDecimal actualSequence = featuredProductImpl.getSequence();

    // Assert
    assertEquals("Promotion Message", actualPromotionMessage);
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(product, actualProduct);
    assertSame(product, actualRelatedProduct);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and {@link FeaturedProductImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl2);
    assertEquals(featuredProductImpl.hashCode(), featuredProductImpl2.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and {@link FeaturedProductImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(null);
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(null);
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl2);
    assertEquals(featuredProductImpl.hashCode(), featuredProductImpl2.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and {@link FeaturedProductImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(null);
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(null);
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl2);
    assertEquals(featuredProductImpl.hashCode(), featuredProductImpl2.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and {@link FeaturedProductImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage(null);
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage(null);
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl2);
    assertEquals(featuredProductImpl.hashCode(), featuredProductImpl2.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and {@link FeaturedProductImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(null);

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(null);

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl2);
    assertEquals(featuredProductImpl.hashCode(), featuredProductImpl2.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}, and {@link FeaturedProductImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FeaturedProductImpl#equals(Object)}
   *   <li>{@link FeaturedProductImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(featuredProductImpl, featuredProductImpl);
    int expectedHashCodeResult = featuredProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, featuredProductImpl.hashCode());
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(null);
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(mock(CategoryImpl.class));
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(product);
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(null);
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage(null);
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("42");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(null);

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(BigDecimal.valueOf(1L));

    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductImpl2.setCategory(new CategoryImpl());
    featuredProductImpl2.setId(1L);
    featuredProductImpl2.setProduct(new ProductBundleImpl());
    featuredProductImpl2.setPromotionMessage("Promotion Message");
    featuredProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, featuredProductImpl2);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, null);
  }

  /**
   * Test {@link FeaturedProductImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FeaturedProductImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FeaturedProductImpl.equals(Object)",
    "int FeaturedProductImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setCategory(new CategoryImpl());
    featuredProductImpl.setId(1L);
    featuredProductImpl.setProduct(new ProductBundleImpl());
    featuredProductImpl.setPromotionMessage("Promotion Message");
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(featuredProductImpl, "Different type to FeaturedProductImpl");
  }

  /**
   * Test new {@link FeaturedProductImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FeaturedProductImpl}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeaturedProductImpl.<init>()"})
  public void testNewFeaturedProductImpl() {
    // Arrange and Act
    FeaturedProductImpl actualFeaturedProductImpl = new FeaturedProductImpl();

    // Assert
    assertTrue(actualFeaturedProductImpl.getCategory() instanceof CategoryImpl);
    Product product = actualFeaturedProductImpl.getProduct();
    assertTrue(product instanceof ProductImpl);
    assertNull(actualFeaturedProductImpl.getId());
    assertNull(actualFeaturedProductImpl.getPromotionMessage());
    assertNull(actualFeaturedProductImpl.getSequence());
    assertSame(product, actualFeaturedProductImpl.getRelatedProduct());
  }
}
