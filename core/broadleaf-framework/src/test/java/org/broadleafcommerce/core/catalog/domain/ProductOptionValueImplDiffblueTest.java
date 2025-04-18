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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
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
public class ProductOptionValueImplDiffblueTest {
  @Autowired
  private ProductOptionValueImpl productOptionValueImpl;

  /**
   * Test {@link ProductOptionValueImpl#getAttributeValue()}.
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl} (default constructor) AttributeValue is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#getAttributeValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductOptionValueImpl.getAttributeValue()"})
  public void testGetAttributeValue_givenProductOptionValueImplAttributeValueIs42_thenReturn42() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act and Assert
    assertEquals("42", productOptionValueImpl2.getAttributeValue());
  }

  /**
   * Test {@link ProductOptionValueImpl#getAttributeValue()}.
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#getAttributeValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ProductOptionValueImpl.getAttributeValue()"})
  public void testGetAttributeValue_givenProductOptionValueImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionValueImpl()).getAttributeValue());
  }

  /**
   * Test {@link ProductOptionValueImpl#getPriceAdjustment()}.
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#getPriceAdjustment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductOptionValueImpl.getPriceAdjustment()"})
  public void testGetPriceAdjustment_givenProductOptionValueImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionValueImpl()).getPriceAdjustment());
  }

  /**
   * Test {@link ProductOptionValueImpl#getPriceAdjustment()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#getPriceAdjustment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductOptionValueImpl.getPriceAdjustment()"})
  public void testGetPriceAdjustment_thenReturnMoney() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());
    Money priceAdjustment = new Money();
    productOptionValueImpl2.setPriceAdjustment(priceAdjustment);

    // Act and Assert
    assertEquals(priceAdjustment, productOptionValueImpl2.getPriceAdjustment());
  }

  /**
   * Test {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductOptionValueImpl.getPriceAdjustmentSkipDynamicPricing()"})
  public void testGetPriceAdjustmentSkipDynamicPricing_thenReturnMoney() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());
    Money priceAdjustment = new Money();
    productOptionValueImpl2.setPriceAdjustment(priceAdjustment);

    // Act and Assert
    assertEquals(priceAdjustment, productOptionValueImpl2.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Test {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#getPriceAdjustmentSkipDynamicPricing()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductOptionValueImpl.getPriceAdjustmentSkipDynamicPricing()"})
  public void testGetPriceAdjustmentSkipDynamicPricing_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ProductOptionValueImpl()).getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Test {@link ProductOptionValueImpl#setPriceAdjustment(Money)}.
   * <p>
   * Method under test: {@link ProductOptionValueImpl#setPriceAdjustment(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionValueImpl.setPriceAdjustment(Money)"})
  public void testSetPriceAdjustment() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    Money priceAdjustment = new Money();

    // Act
    productOptionValueImpl2.setPriceAdjustment(priceAdjustment);

    // Assert
    assertEquals(new BigDecimal("0.00"), productOptionValueImpl2.priceAdjustment);
    BigDecimal bigDecimal = productOptionValueImpl2.priceAdjustment;
    Money absResult = priceAdjustment.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = priceAdjustment.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link ProductOptionValueImpl#setPriceAdjustment(Money)}.
   * <ul>
   *   <li>Then {@link ProductOptionValueImpl} (default constructor) {@link ProductOptionValueImpl#priceAdjustment} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#setPriceAdjustment(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionValueImpl.setPriceAdjustment(Money)"})
  public void testSetPriceAdjustment_thenProductOptionValueImplPriceAdjustmentIsNull() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    productOptionValueImpl2.setAttributeValue("42");
    productOptionValueImpl2.setDisplayOrder(1L);
    productOptionValueImpl2.setId(1L);
    productOptionValueImpl2.setPriceAdjustment(new Money());
    productOptionValueImpl2.setProductOption(new ProductOptionImpl());

    // Act
    productOptionValueImpl2.setPriceAdjustment(null);

    // Assert
    assertNull(productOptionValueImpl2.priceAdjustment);
    assertNull(productOptionValueImpl2.getPriceAdjustment());
    assertNull(productOptionValueImpl2.getPriceAdjustmentSkipDynamicPricing());
  }

  /**
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link ProductOptionValueImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
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
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link ProductOptionValueImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
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
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link ProductOptionValueImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link ProductOptionValueImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
   * Test {@link ProductOptionValueImpl#equals(Object)}, and {@link ProductOptionValueImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValueImpl#equals(Object)}
   *   <li>{@link ProductOptionValueImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
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
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
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
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
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
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
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
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
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
   * Test {@link ProductOptionValueImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionValueImpl.equals(Object)", "int ProductOptionValueImpl.hashCode()"})
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
   * Test {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse ProductOptionValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult = productOptionValueImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link ProductOptionValueImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValueImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse ProductOptionValueImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnProductOptionValueImpl()
      throws CloneNotSupportedException {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl2 = new ProductOptionValueImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<ProductOptionValue> actualCreateOrRetrieveCopyInstanceResult = productOptionValueImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    ProductOptionValue clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof ProductOptionValueImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(productOptionValueImpl2, clone);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductOptionValueImpl.<init>()", "Long ProductOptionValueImpl.getDisplayOrder()",
      "Long ProductOptionValueImpl.getId()", "ProductOption ProductOptionValueImpl.getProductOption()",
      "String ProductOptionValueImpl.getRawAttributeValue()", "void ProductOptionValueImpl.setAttributeValue(String)",
      "void ProductOptionValueImpl.setDisplayOrder(Long)", "void ProductOptionValueImpl.setId(Long)",
      "void ProductOptionValueImpl.setProductOption(ProductOption)"})
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

    // Assert
    assertEquals("42", actualProductOptionValueImpl.getRawAttributeValue());
    assertEquals(1L, actualDisplayOrder.longValue());
    assertEquals(1L, actualId.longValue());
    assertSame(productOption, actualProductOption);
  }
}
