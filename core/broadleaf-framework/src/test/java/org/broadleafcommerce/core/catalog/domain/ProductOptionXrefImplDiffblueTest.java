package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
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
