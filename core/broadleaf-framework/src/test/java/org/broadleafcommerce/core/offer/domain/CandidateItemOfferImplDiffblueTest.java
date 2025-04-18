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
package org.broadleafcommerce.core.offer.domain;

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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
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
public class CandidateItemOfferImplDiffblueTest {
  @Autowired
  private CandidateItemOfferImpl candidateItemOfferImpl;

  /**
   * Test {@link CandidateItemOfferImpl#setOffer(Offer)}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateItemOfferImpl.setOffer(Offer)"})
  public void testSetOffer() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    candidateItemOfferImpl2.setOffer(offer);

    // Assert
    assertTrue(candidateItemOfferImpl2.offer instanceof OfferImpl);
    assertEquals(2147483646, candidateItemOfferImpl2.getPriority());
    assertSame(offer, candidateItemOfferImpl2.getOffer());
    assertSame(offer, candidateItemOfferImpl2.deproxiedOffer);
  }

  /**
   * Test {@link CandidateItemOfferImpl#getOffer()}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getOffer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer CandidateItemOfferImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull((new CandidateItemOfferImpl()).getOffer());
  }

  /**
   * Test {@link CandidateItemOfferImpl#getDiscountedPrice()}.
   * <ul>
   *   <li>Given {@link CandidateItemOfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getDiscountedPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money CandidateItemOfferImpl.getDiscountedPrice()"})
  public void testGetDiscountedPrice_givenCandidateItemOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CandidateItemOfferImpl()).getDiscountedPrice());
  }

  /**
   * Test {@link CandidateItemOfferImpl#getDiscountedPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getDiscountedPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money CandidateItemOfferImpl.getDiscountedPrice()"})
  public void testGetDiscountedPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(CandidateItemOfferImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(CandidateItemOfferImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(CandidateItemOfferImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(CandidateItemOfferImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(CandidateItemOfferImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(CandidateItemOfferImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    Money discountedPrice = new Money();
    candidateItemOfferImpl2.setDiscountedPrice(discountedPrice);
    candidateItemOfferImpl2.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(discountedPrice, candidateItemOfferImpl2.getDiscountedPrice());
  }

  /**
   * Test {@link CandidateItemOfferImpl#setDiscountedPrice(Money)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateItemOfferImpl.setDiscountedPrice(Money)"})
  public void testSetDiscountedPrice_givenBigDecimalWith23_thenCallsGetAmount() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    candidateItemOfferImpl2.setDiscountedPrice(discountedPrice);

    // Assert
    verify(discountedPrice).getAmount();
  }

  /**
   * Test {@link CandidateItemOfferImpl#clone()}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CandidateItemOffer CandidateItemOfferImpl.clone()"})
  public void testClone() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();

    // Act
    CandidateItemOffer actualCloneResult = candidateItemOfferImpl2.clone();

    // Assert
    assertTrue(actualCloneResult instanceof CandidateItemOfferImpl);
    assertEquals(candidateItemOfferImpl2, actualCloneResult);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and {@link CandidateItemOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
    int expectedHashCodeResult = candidateItemOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateItemOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and {@link CandidateItemOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
    int expectedHashCodeResult = candidateItemOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateItemOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and {@link CandidateItemOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(null);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
    int expectedHashCodeResult = candidateItemOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateItemOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and {@link CandidateItemOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl);
    int expectedHashCodeResult = candidateItemOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateItemOfferImpl.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(2L);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money(10.0d));
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(null);

    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, null);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateItemOfferImpl.equals(Object)", "int CandidateItemOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, "Different type to CandidateItemOfferImpl");
  }

  /**
   * Test {@link CandidateItemOfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse CandidateItemOfferImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CandidateItemOffer> actualCreateOrRetrieveCopyInstanceResult = candidateItemOfferImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CandidateItemOfferImpl}
   *   <li>{@link CandidateItemOfferImpl#setId(Long)}
   *   <li>{@link CandidateItemOfferImpl#setOrderItem(OrderItem)}
   *   <li>{@link CandidateItemOfferImpl#getId()}
   *   <li>{@link CandidateItemOfferImpl#getOrderItem()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateItemOfferImpl.<init>()", "Long CandidateItemOfferImpl.getId()",
      "OrderItem CandidateItemOfferImpl.getOrderItem()", "void CandidateItemOfferImpl.setId(Long)",
      "void CandidateItemOfferImpl.setOrderItem(OrderItem)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidateItemOfferImpl actualCandidateItemOfferImpl = new CandidateItemOfferImpl();
    actualCandidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualCandidateItemOfferImpl.setOrderItem(orderItem);
    Long actualId = actualCandidateItemOfferImpl.getId();
    OrderItem actualOrderItem = actualCandidateItemOfferImpl.getOrderItem();

    // Assert
    assertEquals(CandidateItemOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
  }
}
