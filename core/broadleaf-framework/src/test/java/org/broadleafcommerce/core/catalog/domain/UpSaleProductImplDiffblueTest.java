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

public class UpSaleProductImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpSaleProductImpl#setCategory(Category)}
   *   <li>{@link UpSaleProductImpl#setId(Long)}
   *   <li>{@link UpSaleProductImpl#setProduct(Product)}
   *   <li>{@link UpSaleProductImpl#setPromotionMessage(String)}
   *   <li>{@link UpSaleProductImpl#setRelatedProduct(Product)}
   *   <li>{@link UpSaleProductImpl#setSequence(BigDecimal)}
   *   <li>{@link UpSaleProductImpl#getCategory()}
   *   <li>{@link UpSaleProductImpl#getId()}
   *   <li>{@link UpSaleProductImpl#getProduct()}
   *   <li>{@link UpSaleProductImpl#getPromotionMessage()}
   *   <li>{@link UpSaleProductImpl#getRelatedProduct()}
   *   <li>{@link UpSaleProductImpl#getSequence()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    upSaleProductImpl.setCategory(category);
    upSaleProductImpl.setId(1L);
    ProductBundleImpl product = new ProductBundleImpl();
    upSaleProductImpl.setProduct(product);
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    ProductBundleImpl relatedSaleProduct = new ProductBundleImpl();
    upSaleProductImpl.setRelatedProduct(relatedSaleProduct);
    BigDecimal sequence = new BigDecimal("2.3");
    upSaleProductImpl.setSequence(sequence);
    Category actualCategory = upSaleProductImpl.getCategory();
    Long actualId = upSaleProductImpl.getId();
    Product actualProduct = upSaleProductImpl.getProduct();
    String actualPromotionMessage = upSaleProductImpl.getPromotionMessage();
    Product actualRelatedProduct = upSaleProductImpl.getRelatedProduct();
    BigDecimal actualSequence = upSaleProductImpl.getSequence();

    // Assert that nothing has changed
    assertEquals("Promotion Message", actualPromotionMessage);
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(product, actualProduct);
    assertSame(relatedSaleProduct, actualRelatedProduct);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}, and
   * {@link UpSaleProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpSaleProductImpl#equals(Object)}
   *   <li>{@link UpSaleProductImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(upSaleProductImpl, upSaleProductImpl2);
    int expectedHashCodeResult = upSaleProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, upSaleProductImpl2.hashCode());
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}, and
   * {@link UpSaleProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpSaleProductImpl#equals(Object)}
   *   <li>{@link UpSaleProductImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(null);
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(null);
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(upSaleProductImpl, upSaleProductImpl2);
    int expectedHashCodeResult = upSaleProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, upSaleProductImpl2.hashCode());
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}, and
   * {@link UpSaleProductImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpSaleProductImpl#equals(Object)}
   *   <li>{@link UpSaleProductImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(upSaleProductImpl, upSaleProductImpl);
    int expectedHashCodeResult = upSaleProductImpl.hashCode();
    assertEquals(expectedHashCodeResult, upSaleProductImpl.hashCode());
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(null);
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(mock(CategoryImpl.class));
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(product);
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(null);
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage(null);
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("42");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductBundleImpl relatedSaleProduct = new ProductBundleImpl();
    relatedSaleProduct.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(relatedSaleProduct);
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(null);
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("4.5"));

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(null);

    UpSaleProductImpl upSaleProductImpl2 = new UpSaleProductImpl();
    upSaleProductImpl2.setCategory(new CategoryImpl());
    upSaleProductImpl2.setId(1L);
    upSaleProductImpl2.setProduct(new ProductBundleImpl());
    upSaleProductImpl2.setPromotionMessage("Promotion Message");
    upSaleProductImpl2.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, upSaleProductImpl2);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, null);
  }

  /**
   * Test {@link UpSaleProductImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpSaleProductImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(upSaleProductImpl, "Different type to UpSaleProductImpl");
  }

  /**
   * Test
   * {@link UpSaleProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link UpSaleProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<UpSaleProductImpl> actualCreateOrRetrieveCopyInstanceResult = upSaleProductImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link UpSaleProductImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link UpSaleProductImpl}
   */
  @Test
  public void testNewUpSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    UpSaleProductImpl actualUpSaleProductImpl = new UpSaleProductImpl();

    // Assert
    Product relatedProduct = actualUpSaleProductImpl.getRelatedProduct();
    assertTrue(relatedProduct instanceof ProductImpl);
    FieldEntity fieldEntityType = relatedProduct.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', ((ProductImpl) relatedProduct).archiveStatus.getArchived().charValue());
    assertEquals('N', ((ProductImpl) relatedProduct).getArchived().charValue());
    assertNull(relatedProduct.getId());
    assertNull(actualUpSaleProductImpl.getId());
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
    assertNull(actualUpSaleProductImpl.getPromotionMessage());
    assertNull(((ProductImpl) relatedProduct).url);
    assertNull(((ProductImpl) relatedProduct).urlKey);
    assertNull(actualUpSaleProductImpl.getSequence());
    assertNull(relatedProduct.getPrice());
    assertNull(relatedProduct.getRetailPrice());
    assertNull(relatedProduct.getSalePrice());
    assertNull(((ProductImpl) relatedProduct).getRetailPriceInternal());
    assertNull(((ProductImpl) relatedProduct).getSalePriceInternal());
    assertNull(relatedProduct.getCategory());
    assertNull(relatedProduct.getDefaultCategory());
    assertNull(actualUpSaleProductImpl.getCategory());
    assertNull(((ProductImpl) relatedProduct).defaultCategory);
    assertNull(actualUpSaleProductImpl.getProduct());
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
