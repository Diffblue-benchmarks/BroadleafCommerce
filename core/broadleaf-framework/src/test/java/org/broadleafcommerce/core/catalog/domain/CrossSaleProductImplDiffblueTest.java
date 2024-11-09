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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class CrossSaleProductImplDiffblueTest {
  /**
   * Test {@link CrossSaleProductImpl#getPromotionMessage()}.
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#getPromotionMessage()}
   */
  @Test
  public void testGetPromotionMessage_givenCrossSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CrossSaleProductImpl()).getPromotionMessage());
  }

  /**
   * Test {@link CrossSaleProductImpl#getPromotionMessage()}.
   * <ul>
   *   <li>Given {@link CrossSaleProductImpl} (default constructor) Sequence is
   * {@link InternalNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CrossSaleProductImpl#getPromotionMessage()}
   */
  @Test
  public void testGetPromotionMessage_givenCrossSaleProductImplSequenceIsInternalNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProductImpl.setSequence(mock(InternalNumber.class));

    // Act and Assert
    assertNull(crossSaleProductImpl.getPromotionMessage());
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

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(product, actualProduct);
    assertSame(relatedSaleProduct, actualRelatedProduct);
  }

  /**
   * Test {@link CrossSaleProductImpl#equals(Object)}, and
   * {@link CrossSaleProductImpl#hashCode()}.
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
   * Test {@link CrossSaleProductImpl#equals(Object)}, and
   * {@link CrossSaleProductImpl#hashCode()}.
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
   * Test {@link CrossSaleProductImpl#equals(Object)}, and
   * {@link CrossSaleProductImpl#hashCode()}.
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
   * Test
   * {@link CrossSaleProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CrossSaleProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CrossSaleProductImpl> actualCreateOrRetrieveCopyInstanceResult = crossSaleProductImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link CrossSaleProductImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CrossSaleProductImpl}
   */
  @Test
  public void testNewCrossSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CrossSaleProductImpl actualCrossSaleProductImpl = new CrossSaleProductImpl();

    // Assert
    Product relatedProduct = actualCrossSaleProductImpl.getRelatedProduct();
    assertTrue(relatedProduct instanceof ProductImpl);
    FieldEntity fieldEntityType = relatedProduct.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) relatedProduct).archiveStatus.getArchived().charValue());
    assertEquals('N', ((ProductImpl) relatedProduct).getArchived().charValue());
    assertNull(actualCrossSaleProductImpl.getId());
    assertNull(relatedProduct.getId());
    assertNull(actualCrossSaleProductImpl.getPromotionMessage());
    assertNull(relatedProduct.getCanonicalUrl());
    assertNull(relatedProduct.getDisplayTemplate());
    assertNull(relatedProduct.getGeneratedUrl());
    assertNull(relatedProduct.getManufacturer());
    assertNull(relatedProduct.getMetaDescription());
    assertNull(relatedProduct.getMetaTitle());
    assertNull(relatedProduct.getModel());
    assertNull(relatedProduct.getPromoMessage());
    assertNull(relatedProduct.getUrl());
    assertNull(((ProductImpl) relatedProduct).getLocation());
    assertNull(actualCrossSaleProductImpl.promotionMessage);
    assertNull(((ProductImpl) relatedProduct).url);
    assertNull(((ProductImpl) relatedProduct).urlKey);
    assertNull(actualCrossSaleProductImpl.getSequence());
    assertNull(relatedProduct.getPrice());
    assertNull(relatedProduct.getRetailPrice());
    assertNull(relatedProduct.getSalePrice());
    assertNull(((ProductImpl) relatedProduct).getRetailPriceInternal());
    assertNull(((ProductImpl) relatedProduct).getSalePriceInternal());
    assertNull(actualCrossSaleProductImpl.getCategory());
    assertNull(relatedProduct.getCategory());
    assertNull(relatedProduct.getDefaultCategory());
    assertNull(((ProductImpl) relatedProduct).defaultCategory);
    assertNull(actualCrossSaleProductImpl.getProduct());
    List<Sku> allSellableSkus = relatedProduct.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(relatedProduct.getDefaultSku());
    assertFalse(relatedProduct.getCanSellWithoutOptions());
    assertFalse(relatedProduct.getOverrideGeneratedUrl());
    assertFalse(relatedProduct.hasRetailPrice());
    assertFalse(((ProductImpl) relatedProduct).canSellWithoutOptions);
    assertFalse(((ProductImpl) relatedProduct).isFeaturedProduct);
    assertFalse(((ProductImpl) relatedProduct).overrideGeneratedUrl);
    assertTrue(relatedProduct.getAdditionalSkus().isEmpty());
    assertTrue(relatedProduct.getAllParentCategories().isEmpty());
    assertTrue(relatedProduct.getAllParentCategoryIds().isEmpty());
    assertTrue(relatedProduct.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = relatedProduct.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = relatedProduct.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(relatedProduct.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(relatedProduct.getProductOptionXrefs().isEmpty());
    assertTrue(relatedProduct.getProductOptions().isEmpty());
    assertTrue(relatedProduct.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(((ProductImpl) relatedProduct).productAttributes.isEmpty());
    assertTrue(((ProductImpl) relatedProduct).productOptions.isEmpty());
    assertTrue(((ProductImpl) relatedProduct).skus.isEmpty());
    assertTrue(relatedProduct.getMultiValueProductAttributes().isEmpty());
    assertTrue(relatedProduct.getProductAttributes().isEmpty());
    assertTrue(relatedProduct.getProductOptionValuesMap().isEmpty());
    assertEquals(allSellableSkus, relatedProduct.getAllSkus());
    assertSame(crossSaleProducts, relatedProduct.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, relatedProduct.getUpSaleProducts());
  }
}
