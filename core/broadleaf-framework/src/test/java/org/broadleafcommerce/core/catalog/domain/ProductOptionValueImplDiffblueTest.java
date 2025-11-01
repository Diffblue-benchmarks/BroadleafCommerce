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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductOptionValueImplDiffblueTest {
  /**
   * Method under test: {@link ProductOptionValueImpl#getAttributeValue()}
   */
  @Test
  public void testGetAttributeValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionValueImpl()).getAttributeValue());
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#getAttributeValue()}
   */
  @Test
  public void testGetAttributeValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals("42", productOptionValueImpl.getAttributeValue());
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#getAttributeValue()}
   */
  @Test
  public void testGetAttributeValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(mock(Money.class));
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals("42", productOptionValueImpl.getAttributeValue());
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#getPriceAdjustment()}
   */
  @Test
  public void testGetPriceAdjustment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionValueImpl()).getPriceAdjustment());
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#getPriceAdjustment()}
   */
  @Test
  public void testGetPriceAdjustment2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setProductOption(new ProductOptionImpl());
    Money priceAdjustment = new Money();
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    // Act and Assert
    assertEquals(priceAdjustment, productOptionValueImpl.getPriceAdjustment());
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#getPriceAdjustment()}
   */
  @Test
  public void testGetPriceAdjustment3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setProductOption(mock(ProductOption.class));
    Money priceAdjustment = new Money();
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    // Act and Assert
    assertEquals(priceAdjustment, productOptionValueImpl.getPriceAdjustment());
  }

  /**
   * Method under test:
   * {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}
   */
  @Test
  public void testGetPriceAdjustmentSkipDynamicPricing() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductOptionValueImpl()).getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Method under test:
   * {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}
   */
  @Test
  public void testGetPriceAdjustmentSkipDynamicPricing2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setProductOption(new ProductOptionImpl());
    Money priceAdjustment = new Money();
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    // Act and Assert
    assertEquals(priceAdjustment, productOptionValueImpl.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Method under test:
   * {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}
   */
  @Test
  public void testGetPriceAdjustmentSkipDynamicPricing3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setProductOption(mock(ProductOption.class));
    Money priceAdjustment = new Money();
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    // Act and Assert
    assertEquals(priceAdjustment, productOptionValueImpl.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#setPriceAdjustment(Money)}
   */
  @Test
  public void testSetPriceAdjustment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    Money priceAdjustment = new Money();

    // Act
    productOptionValueImpl.setPriceAdjustment(priceAdjustment);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = priceAdjustment.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), productOptionValueImpl.priceAdjustment);
    assertEquals(priceAdjustment, priceAdjustment.abs());
    assertEquals(priceAdjustment, priceAdjustment.zero());
    assertSame(productOptionValueImpl.priceAdjustment, amount);
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#setPriceAdjustment(Money)}
   */
  @Test
  public void testSetPriceAdjustment2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act
    productOptionValueImpl.setPriceAdjustment(null);

    // Assert
    assertNull(productOptionValueImpl.priceAdjustment);
    assertNull(productOptionValueImpl.getPriceAdjustment());
    assertNull(productOptionValueImpl.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#setPriceAdjustment(Money)}
   */
  @Test
  public void testSetPriceAdjustment3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();

    // Act
    productOptionValueImpl.setPriceAdjustment(mock(Money.class));

    // Assert
    assertNull(productOptionValueImpl.priceAdjustment);
    assertNull(productOptionValueImpl.getPriceAdjustment());
    assertNull(productOptionValueImpl.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    int expectedHashCodeResult = productOptionValueImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValueImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    int notExpectedHashCodeResult = productOptionValueImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, productOptionValueImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(mock(Money.class));
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    int expectedHashCodeResult = productOptionValueImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValueImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(null);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    int notExpectedHashCodeResult = productOptionValueImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, productOptionValueImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue(null);
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue(null);
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl2);
    int notExpectedHashCodeResult = productOptionValueImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, productOptionValueImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals(productOptionValueImpl, productOptionValueImpl);
    int expectedHashCodeResult = productOptionValueImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValueImpl.hashCode());
  }

  /**
   * Method under test:
   * {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult = productOptionValueImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    ProductOptionValue clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof ProductOptionValueImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(productOptionValueImpl, clone);
  }

  /**
   * Method under test:
   * {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult = productOptionValueImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(2L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("Attribute Value");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue(null);
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(null);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, productOptionValueImpl2);
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, null);
  }

  /**
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertNotEquals(productOptionValueImpl, "Different type to ProductOptionValueImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ProductOptionValueImpl}
   *   <li>{@link ProductOptionValueImpl#setAttributeValue(String)}
   *   <li>{@link ProductOptionValueImpl#setDisplayOrder(Long)}
   *   <li>{@link ProductOptionValueImpl#setId(Long)}
   *   <li>{@link ProductOptionValueImpl#setProductOption(ProductOption)}
   *   <li>{@link ProductOptionValueImpl#getDisplayOrder()}
   *   <li>{@link ProductOptionValueImpl#getId()}
   *   <li>{@link ProductOptionValueImpl#getProductOption()}
   *   <li>{@link ProductOptionValueImpl#getRawAttributeValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductOptionValueImpl actualProductOptionValueImpl = new ProductOptionValueImpl();
    actualProductOptionValueImpl.setAttributeValue("42");
    actualProductOptionValueImpl.setDisplayOrder(1L);
    actualProductOptionValueImpl.setId(1L);
    ProductOptionImpl productOption = new ProductOptionImpl();
    actualProductOptionValueImpl.setProductOption(productOption);
    Long actualDisplayOrder = actualProductOptionValueImpl.getDisplayOrder();
    Long actualId = actualProductOptionValueImpl.getId();
    ProductOption actualProductOption = actualProductOptionValueImpl.getProductOption();

    // Assert that nothing has changed
    assertEquals("42", actualProductOptionValueImpl.getRawAttributeValue());
    assertEquals(1L, actualDisplayOrder.longValue());
    assertEquals(1L, actualId.longValue());
    assertSame(productOption, actualProductOption);
  }
}
