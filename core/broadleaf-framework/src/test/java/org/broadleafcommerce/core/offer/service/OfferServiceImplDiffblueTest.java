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
package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.dao.CustomerOfferDao;
import org.broadleafcommerce.core.offer.dao.CustomerOfferDaoImpl;
import org.broadleafcommerce.core.offer.dao.OfferCodeDao;
import org.broadleafcommerce.core.offer.dao.OfferCodeDaoImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.domain.CustomerOffer;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.processor.BaseProcessor;
import org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessor;
import org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl;
import org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessor;
import org.broadleafcommerce.core.offer.service.processor.ItemOfferProcessorImpl;
import org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessor;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.OrderServiceImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OfferServiceImplDiffblueTest {
  /**
   * Test {@link OfferServiceImpl#findAllOffers()}.
   * <ul>
   *   <li>Given {@link OfferDaoImpl} {@link OfferDaoImpl#readAllOffers()} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findAllOffers()}
   */
  @Test
  public void testFindAllOffers_givenOfferDaoImplReadAllOffersReturnArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    when(offerDao.readAllOffers()).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);

    // Act
    List<Offer> actualFindAllOffersResult = offerServiceImpl.findAllOffers();

    // Assert
    verify(offerDao).readAllOffers();
    assertTrue(actualFindAllOffersResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#save(Offer)}.
   * <ul>
   *   <li>Given {@link OfferDaoImpl} {@link OfferDaoImpl#save(Offer)} return
   * {@link OfferImpl} (default constructor).</li>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#save(Offer)}
   */
  @Test
  public void testSave_givenOfferDaoImplSaveReturnOfferImpl_whenOfferImpl_thenReturnOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    OfferImpl offerImpl = new OfferImpl();
    when(offerDao.save(Mockito.<Offer>any())).thenReturn(offerImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);

    // Act
    Offer actualSaveResult = offerServiceImpl.save(new OfferImpl());

    // Assert
    verify(offerDao).save(isA(Offer.class));
    assertSame(offerImpl, actualSaveResult);
  }

  /**
   * Test {@link OfferServiceImpl#saveOfferCode(OfferCode)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#saveOfferCode(OfferCode)}
   */
  @Test
  public void testSaveOfferCode_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    when(offerDao.save(Mockito.<Offer>any())).thenReturn(new OfferImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);
    OfferCode offerCode = mock(OfferCode.class);
    doThrow(new RuntimeException("foo")).when(offerCode).setOffer(Mockito.<Offer>any());
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.saveOfferCode(offerCode));
    verify(offerDao).save(isA(Offer.class));
    verify(offerCode).getOffer();
    verify(offerCode).setOffer(isA(Offer.class));
  }

  /**
   * Test {@link OfferServiceImpl#saveOfferCode(OfferCode)}.
   * <ul>
   *   <li>Then return {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#saveOfferCode(OfferCode)}
   */
  @Test
  public void testSaveOfferCode_thenReturnOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    when(offerDao.save(Mockito.<Offer>any())).thenReturn(new OfferImpl());
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    when(offerCodeDao.save(Mockito.<OfferCode>any())).thenReturn(offerCodeImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);
    offerServiceImpl.setOfferDao(offerDao);
    OfferCode offerCode = mock(OfferCode.class);
    doNothing().when(offerCode).setOffer(Mockito.<Offer>any());
    when(offerCode.getOffer()).thenReturn(new OfferImpl());

    // Act
    OfferCode actualSaveOfferCodeResult = offerServiceImpl.saveOfferCode(offerCode);

    // Assert
    verify(offerCodeDao).save(isA(OfferCode.class));
    verify(offerDao).save(isA(Offer.class));
    verify(offerCode).getOffer();
    verify(offerCode).setOffer(isA(Offer.class));
    assertSame(offerCodeImpl, actualSaveOfferCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferByCode(String)}.
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupOfferByCode(String)}
   */
  @Test
  public void testLookupOfferByCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(new OfferCodeImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    Offer actualLookupOfferByCodeResult = offerServiceImpl.lookupOfferByCode("Code");

    // Assert
    verify(offerCodeDao).readOfferCodeByCode(eq("Code"));
    assertNull(actualLookupOfferByCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferByCode(String)}.
   * <ul>
   *   <li>Given {@link OfferCodeDaoImpl}
   * {@link OfferCodeDaoImpl#readOfferCodeByCode(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupOfferByCode(String)}
   */
  @Test
  public void testLookupOfferByCode_givenOfferCodeDaoImplReadOfferCodeByCodeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(null);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    Offer actualLookupOfferByCodeResult = offerServiceImpl.lookupOfferByCode("Code");

    // Assert
    verify(offerCodeDao).readOfferCodeByCode(eq("Code"));
    assertNull(actualLookupOfferByCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferByCode(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupOfferByCode(String)}
   */
  @Test
  public void testLookupOfferByCode_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.getOffer()).thenThrow(new RuntimeException("foo"));
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(offerCodeImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupOfferByCode("Code"));
    verify(offerCodeDao).readOfferCodeByCode(eq("Code"));
    verify(offerCodeImpl).getOffer();
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferCodeByCode(String)}.
   * <ul>
   *   <li>Then return {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupOfferCodeByCode(String)}
   */
  @Test
  public void testLookupOfferCodeByCode_thenReturnOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    when(offerCodeDao.readOfferCodeByCode(Mockito.<String>any())).thenReturn(offerCodeImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    OfferCode actualLookupOfferCodeByCodeResult = offerServiceImpl.lookupOfferCodeByCode("Code");

    // Assert
    verify(offerCodeDao).readOfferCodeByCode(eq("Code"));
    assertSame(offerCodeImpl, actualLookupOfferCodeByCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  public void testLookupAllOffersByCode_givenArrayListAddNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(null);
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(offerCodeList);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<Offer> actualLookupAllOffersByCodeResult = offerServiceImpl.lookupAllOffersByCode("Code");

    // Assert
    verify(offerCodeDao).readAllOfferCodesByCode(eq("Code"));
    assertTrue(actualLookupAllOffersByCodeResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default
   * constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  public void testLookupAllOffersByCode_givenArrayListAddOfferCodeImpl_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(new OfferCodeImpl());
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(offerCodeList);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<Offer> actualLookupAllOffersByCodeResult = offerServiceImpl.lookupAllOffersByCode("Code");

    // Assert
    verify(offerCodeDao).readAllOfferCodesByCode(eq("Code"));
    assertEquals(1, actualLookupAllOffersByCodeResult.size());
    assertNull(actualLookupAllOffersByCodeResult.get(0));
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  public void testLookupAllOffersByCode_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<Offer> actualLookupAllOffersByCodeResult = offerServiceImpl.lookupAllOffersByCode("Code");

    // Assert
    verify(offerCodeDao).readAllOfferCodesByCode(eq("Code"));
    assertTrue(actualLookupAllOffersByCodeResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOffersByCode(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupAllOffersByCode(String)}
   */
  @Test
  public void testLookupAllOffersByCode_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.getOffer()).thenThrow(new RuntimeException("foo"));

    ArrayList<OfferCode> offerCodeList = new ArrayList<>();
    offerCodeList.add(offerCodeImpl);
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(offerCodeList);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.lookupAllOffersByCode("Code"));
    verify(offerCodeDao).readAllOfferCodesByCode(eq("Code"));
    verify(offerCodeImpl).getOffer();
  }

  /**
   * Test {@link OfferServiceImpl#lookupAllOfferCodesByCode(String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupAllOfferCodesByCode(String)}
   */
  @Test
  public void testLookupAllOfferCodesByCode_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readAllOfferCodesByCode(Mockito.<String>any())).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<OfferCode> actualLookupAllOfferCodesByCodeResult = offerServiceImpl.lookupAllOfferCodesByCode("Code");

    // Assert
    verify(offerCodeDao).readAllOfferCodesByCode(eq("Code"));
    assertTrue(actualLookupAllOfferCodesByCodeResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  public void testBuildOfferCodeListForCustomerWithCustomer_whenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    // Act and Assert
    assertTrue(offerServiceImpl.buildOfferCodeListForCustomer(new CustomerImpl()).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)} with
   * {@code customer}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#buildOfferCodeListForCustomer(Customer)}
   */
  @Test
  public void testBuildOfferCodeListForCustomerWithCustomer_whenCustomerImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferServiceImpl()).buildOfferCodeListForCustomer(mock(CustomerImpl.class)).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with
   * {@code order}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getCustomer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  public void testBuildOfferCodeListForCustomerWithOrder_thenCallsGetCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCustomer()).thenReturn(new CustomerImpl());

    // Act
    List<OfferCode> actualBuildOfferCodeListForCustomerResult = offerServiceImpl.buildOfferCodeListForCustomer(order);

    // Assert
    verify(order).getCustomer();
    assertTrue(actualBuildOfferCodeListForCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)} with
   * {@code order}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#buildOfferCodeListForCustomer(Order)}
   */
  @Test
  public void testBuildOfferCodeListForCustomerWithOrder_whenNullOrderImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    // Act and Assert
    assertTrue(offerServiceImpl.buildOfferCodeListForCustomer(new NullOrderImpl()).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupOfferCustomerByCustomer(Customer)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#lookupOfferCustomerByCustomer(Customer)}
   */
  @Test
  public void testLookupOfferCustomerByCustomer_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerOfferDaoImpl customerOfferDao = mock(CustomerOfferDaoImpl.class);
    when(customerOfferDao.readCustomerOffersByCustomer(Mockito.<Customer>any())).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setCustomerOfferDao(customerOfferDao);

    // Act
    List<CustomerOffer> actualLookupOfferCustomerByCustomerResult = offerServiceImpl
        .lookupOfferCustomerByCustomer(new CustomerImpl());

    // Assert
    verify(customerOfferDao).readCustomerOffersByCustomer(isA(Customer.class));
    assertTrue(actualLookupOfferCustomerByCustomerResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#lookupAutomaticDeliveryOffers()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#lookupAutomaticDeliveryOffers()}
   */
  @Test
  public void testLookupAutomaticDeliveryOffers_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    when(offerDao.readOffersByAutomaticDeliveryType()).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);

    // Act
    List<Offer> actualLookupAutomaticDeliveryOffersResult = offerServiceImpl.lookupAutomaticDeliveryOffers();

    // Assert
    verify(offerDao).readOffersByAutomaticDeliveryType();
    assertTrue(actualLookupAutomaticDeliveryOffersResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} {@link OfferCodeImpl#isActive()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}
   */
  @Test
  public void testRemoveOutOfDateOfferCodes_givenOfferCodeImplIsActiveReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.isActive()).thenReturn(false);

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(offerCodeImpl);

    // Act
    List<OfferCode> actualRemoveOutOfDateOfferCodesResult = offerServiceImpl.removeOutOfDateOfferCodes(offerCodes);

    // Assert
    verify(offerCodeImpl).isActive();
    assertTrue(offerCodes.isEmpty());
    assertTrue(actualRemoveOutOfDateOfferCodesResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}
   */
  @Test
  public void testRemoveOutOfDateOfferCodes_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    OfferCodeImpl offerCodeImpl = mock(OfferCodeImpl.class);
    when(offerCodeImpl.isActive()).thenReturn(true);

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(offerCodeImpl);

    // Act
    List<OfferCode> actualRemoveOutOfDateOfferCodesResult = offerServiceImpl.removeOutOfDateOfferCodes(offerCodes);

    // Assert
    verify(offerCodeImpl).isActive();
    assertEquals(1, offerCodes.size());
    assertSame(offerCodes, actualRemoveOutOfDateOfferCodesResult);
  }

  /**
   * Test {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#removeOutOfDateOfferCodes(List)}
   */
  @Test
  public void testRemoveOutOfDateOfferCodes_whenArrayList_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    ArrayList<OfferCode> offerCodes = new ArrayList<>();

    // Act
    List<OfferCode> actualRemoveOutOfDateOfferCodesResult = offerServiceImpl.removeOutOfDateOfferCodes(offerCodes);

    // Assert
    assertTrue(offerCodes.isEmpty());
    assertTrue(actualRemoveOutOfDateOfferCodesResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#applyAndSaveOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#applyAndSaveOffersToOrder(List, Order)}
   */
  @Test
  public void testApplyAndSaveOffersToOrder_thenReturnNullOrderImpl() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessor orderOfferProcessor = mock(OrderOfferProcessor.class);
    when(orderOfferProcessor.filterOffers(Mockito.<List<Offer>>any(), Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderOfferProcessor).synchronizeAdjustmentsAndPrices(Mockito.<PromotableOrder>any());
    OrderService orderService = mock(OrderService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    ArrayList<Offer> offers = new ArrayList<>();
    Order order = mock(Order.class);
    when(order.finalizeItemPrices()).thenReturn(true);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.calculateSubTotal()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    Order actualApplyAndSaveOffersToOrderResult = offerServiceImpl.applyAndSaveOffersToOrder(offers, order);

    // Assert
    verify(orderOfferProcessor).filterOffers(isA(List.class), isA(Customer.class));
    verify(orderOfferProcessor).synchronizeAdjustmentsAndPrices(isA(PromotableOrder.class));
    verify(order).calculateSubTotal();
    verify(order).finalizeItemPrices();
    verify(order).getCustomer();
    verify(order, atLeast(1)).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(nullOrderImpl, actualApplyAndSaveOffersToOrderResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   * <p>
   * Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  public void testVerifyAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(order, false));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  public void testVerifyAdjustments_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(new ArrayList<>());

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(order, false));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor)
   * OrderItemPriceDetails is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  public void testVerifyAdjustments_givenBundleOrderItemImplOrderItemPriceDetailsIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(order, false));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor)
   * OrderItemPriceDetails is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  public void testVerifyAdjustments_givenBundleOrderItemImplOrderItemPriceDetailsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(null);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(order, false));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor)
   * OrderItemAdjustments is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  public void testVerifyAdjustments_givenOrderItemPriceDetailImplOrderItemAdjustmentsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(1L);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(null);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(orderItemPriceDetailImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(order, false));
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  public void testVerifyAdjustments_thenCallsGetOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    boolean actualVerifyAdjustmentsResult = offerServiceImpl.verifyAdjustments(order, true);

    // Assert
    verify(order, atLeast(1)).getOrderItems();
    assertFalse(actualVerifyAdjustmentsResult);
  }

  /**
   * Test {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#verifyAdjustments(Order, boolean)}
   */
  @Test
  public void testVerifyAdjustments_whenNullOrderImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    // Act and Assert
    assertFalse(offerServiceImpl.verifyAdjustments(new NullOrderImpl(), true));
  }

  /**
   * Test {@link OfferServiceImpl#applyOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then calls {@link BaseProcessor#filterOffers(List, Customer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#applyOffersToOrder(List, Order)}
   */
  @Test
  public void testApplyOffersToOrder_thenCallsFilterOffers() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessor orderOfferProcessor = mock(OrderOfferProcessor.class);
    when(orderOfferProcessor.filterOffers(Mockito.<List<Offer>>any(), Mockito.<Customer>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(orderOfferProcessor).synchronizeAdjustmentsAndPrices(Mockito.<PromotableOrder>any());
    OrderService orderService = mock(OrderService.class);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    ArrayList<Offer> offers = new ArrayList<>();
    Order order = mock(Order.class);
    when(order.finalizeItemPrices()).thenReturn(true);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.calculateSubTotal()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    offerServiceImpl.applyOffersToOrder(offers, order);

    // Assert
    verify(orderOfferProcessor).filterOffers(isA(List.class), isA(Customer.class));
    verify(orderOfferProcessor).synchronizeAdjustmentsAndPrices(isA(PromotableOrder.class));
    verify(order).calculateSubTotal();
    verify(order).finalizeItemPrices();
    verify(order).getCustomer();
    verify(order, atLeast(1)).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test
   * {@link OfferServiceImpl#applyFulfillmentGroupOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then calls {@link OfferImpl#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#applyFulfillmentGroupOffersToOrder(List, Order)}
   */
  @Test
  public void testApplyFulfillmentGroupOffersToOrder_thenCallsGetType() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderService orderService = mock(OrderService.class);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()));
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getType()).thenReturn(OfferType.ORDER);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    offerServiceImpl.applyFulfillmentGroupOffersToOrder(offers, new NullOrderImpl());

    // Assert
    verify(offerImpl).getType();
    verify(orderService).save(isA(Order.class), eq(false));
  }

  /**
   * Test
   * {@link OfferServiceImpl#applyAndSaveFulfillmentGroupOffersToOrder(List, Order)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#applyAndSaveFulfillmentGroupOffersToOrder(List, Order)}
   */
  @Test
  public void testApplyAndSaveFulfillmentGroupOffersToOrder_thenReturnNullOrderImpl() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderService orderService = mock(OrderService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    offerServiceImpl.setOrderOfferProcessor(new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()));
    offerServiceImpl.setPromotableItemFactory(new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getType()).thenReturn(OfferType.ORDER);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    Order actualApplyAndSaveFulfillmentGroupOffersToOrderResult = offerServiceImpl
        .applyAndSaveFulfillmentGroupOffersToOrder(offers, new NullOrderImpl());

    // Assert
    verify(offerImpl).getType();
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(nullOrderImpl, actualApplyAndSaveFulfillmentGroupOffersToOrderResult);
  }

  /**
   * Test
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, OfferCode)}
   * with {@code customer}, {@code code}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, OfferCode)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithCustomerCode_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerImpl customer = new CustomerImpl();
    OfferCode code = mock(OfferCode.class);
    when(code.isLimitedUse()).thenReturn(false);
    when(code.getOffer()).thenReturn(new OfferImpl());

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult = offerServiceImpl.verifyMaxCustomerUsageThreshold(customer,
        code);

    // Assert
    verify(code).getOffer();
    verify(code).isLimitedUse();
    assertTrue(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, OfferCode)}
   * with {@code customer}, {@code code}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, OfferCode)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithCustomerCode_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerImpl customer = new CustomerImpl();
    OfferCode code = mock(OfferCode.class);
    when(code.getId()).thenThrow(new RuntimeException("foo"));
    when(code.isLimitedUse()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, code));
    verify(code).getId();
    verify(code).isLimitedUse();
  }

  /**
   * Test
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)}
   * with {@code customer}, {@code offer}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithCustomerOffer_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertTrue(offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, new OfferImpl()));
  }

  /**
   * Test
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)}
   * with {@code customer}, {@code offer}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Customer, Offer)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithCustomerOffer_whenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertTrue(offerServiceImpl.verifyMaxCustomerUsageThreshold(customer, new OfferImpl()));
  }

  /**
   * Test
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)}
   * with {@code order}, {@code code}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode_givenOfferImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    OfferCode code = mock(OfferCode.class);
    when(code.isLimitedUse()).thenReturn(false);
    when(code.getOffer()).thenReturn(new OfferImpl());

    // Act
    boolean actualVerifyMaxCustomerUsageThresholdResult = offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code);

    // Assert
    verify(code).getOffer();
    verify(code).isLimitedUse();
    assertTrue(actualVerifyMaxCustomerUsageThresholdResult);
  }

  /**
   * Test
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)}
   * with {@code order}, {@code code}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link OfferCode#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode_givenTrue_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    OfferCode code = mock(OfferCode.class);
    when(code.getId()).thenThrow(new RuntimeException("foo"));
    when(code.isLimitedUse()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code));
    verify(code).getId();
    verify(code).isLimitedUse();
  }

  /**
   * Test
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)}
   * with {@code order}, {@code code}.
   * <ul>
   *   <li>Then calls {@link OfferImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, OfferCode)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithOrderCode_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getId()).thenThrow(new RuntimeException("ACCOUNT"));
    when(offerImpl.getMaxUsesStrategyType()).thenReturn(CustomerMaxUsesStrategyType.ACCOUNT);
    when(offerImpl.isLimitedUsePerCustomer()).thenReturn(true);
    OfferCode code = mock(OfferCode.class);
    when(code.isLimitedUse()).thenReturn(false);
    when(code.getOffer()).thenReturn(offerImpl);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> offerServiceImpl.verifyMaxCustomerUsageThreshold(order, code));
    verify(code).getOffer();
    verify(code).isLimitedUse();
    verify(offerImpl).getId();
    verify(offerImpl).getMaxUsesStrategyType();
    verify(offerImpl).isLimitedUsePerCustomer();
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   * with {@code order}, {@code offer}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertTrue(offerServiceImpl.verifyMaxCustomerUsageThreshold(order, new OfferImpl()));
  }

  /**
   * Test {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   * with {@code order}, {@code offer}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#verifyMaxCustomerUsageThreshold(Order, Offer)}
   */
  @Test
  public void testVerifyMaxCustomerUsageThresholdWithOrderOffer_whenOfferImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertTrue(offerServiceImpl.verifyMaxCustomerUsageThreshold(order, new OfferImpl()));
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  public void testGetUniqueOffersFromOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setRetailShippingPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleShippingPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setShippingPrice(new Money());
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(null);
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   * <p>
   * Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  public void testGetUniqueOffersFromOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    order.setFulfillmentGroups(null);

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor)
   * OrderItemPriceDetails is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  public void testGetUniqueOffersFromOrder_givenBundleOrderItemImplOrderItemPriceDetailsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrderItemPriceDetails(null);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(orderItems);
    order.setFulfillmentGroups(null);

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  public void testGetUniqueOffersFromOrder_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    Set<Offer> actualUniqueOffersFromOrder = offerServiceImpl.getUniqueOffersFromOrder(order);

    // Assert
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderAdjustments();
    verify(order, atLeast(1)).getOrderItems();
    assertTrue(actualUniqueOffersFromOrder.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  public void testGetUniqueOffersFromOrder_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    orderAdjustmentList.add(new OrderAdjustmentImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    Set<Offer> actualUniqueOffersFromOrder = offerServiceImpl.getUniqueOffersFromOrder(order);

    // Assert
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderAdjustments();
    verify(order, atLeast(1)).getOrderItems();
    assertEquals(1, actualUniqueOffersFromOrder.size());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor) FulfillmentGroups is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  public void testGetUniqueOffersFromOrder_whenOrderImplFulfillmentGroupsIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(null);
    order.setFulfillmentGroups(new ArrayList<>());

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor) OrderItems is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  public void testGetUniqueOffersFromOrder_whenOrderImplOrderItemsIsArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(new ArrayList<>());
    order.setFulfillmentGroups(null);

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor) OrderItems is
   * {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#getUniqueOffersFromOrder(Order)}
   */
  @Test
  public void testGetUniqueOffersFromOrder_whenOrderImplOrderItemsIsNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setOrderItems(null);
    order.setFulfillmentGroups(null);

    // Act and Assert
    assertTrue(offerServiceImpl.getUniqueOffersFromOrder(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with
   * {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    ArrayList<OfferCode> codes = new ArrayList<>();

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(codes, new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)} with
   * {@code codes}, {@code appliedOffers}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#getOffersRetrievedFromCodes(List, Set)}
   */
  @Test
  public void testGetOffersRetrievedFromCodesWithCodesAppliedOffers_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    ArrayList<OfferCode> codes = new ArrayList<>();

    HashSet<Offer> appliedOffers = new HashSet<>();
    appliedOffers.add(new OfferImpl());

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(codes, appliedOffers).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with
   * {@code order}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(order).getAddedOfferCodes();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderAdjustments();
    verify(order, atLeast(1)).getOrderItems();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with
   * {@code order}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddFulfillmentGroupImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(order).getAddedOfferCodes();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderAdjustments();
    verify(order, atLeast(1)).getOrderItems();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with
   * {@code order}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderAdjustmentImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  public void testGetOffersRetrievedFromCodesWithOrder_givenArrayListAddOrderAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    orderAdjustmentList.add(new OrderAdjustmentImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(order).getAddedOfferCodes();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderAdjustments();
    verify(order, atLeast(1)).getOrderItems();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with
   * {@code order}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  public void testGetOffersRetrievedFromCodesWithOrder_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
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
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(offerServiceImpl.getOffersRetrievedFromCodes(order).isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)} with
   * {@code order}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getAddedOfferCodes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceImpl#getOffersRetrievedFromCodes(Order)}
   */
  @Test
  public void testGetOffersRetrievedFromCodesWithOrder_thenCallsGetAddedOfferCodes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getAddedOfferCodes()).thenReturn(new ArrayList<>());
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    Map<Offer, OfferCode> actualOffersRetrievedFromCodes = offerServiceImpl.getOffersRetrievedFromCodes(order);

    // Assert
    verify(order).getAddedOfferCodes();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrderAdjustments();
    verify(order, atLeast(1)).getOrderItems();
    assertTrue(actualOffersRetrievedFromCodes.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  public void testDeleteOfferCode_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenReturn(true);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    Boolean actualDeleteOfferCodeResult = offerServiceImpl.deleteOfferCode(new OfferCodeImpl());

    // Assert
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
    assertFalse(actualDeleteOfferCodeResult);
  }

  /**
   * Test {@link OfferServiceImpl#deleteOfferCode(OfferCode)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#deleteOfferCode(OfferCode)}
   */
  @Test
  public void testDeleteOfferCode_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.offerCodeIsUsed(Mockito.<OfferCode>any())).thenReturn(false);
    doNothing().when(offerCodeDao).delete(Mockito.<OfferCode>any());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    Boolean actualDeleteOfferCodeResult = offerServiceImpl.deleteOfferCode(new OfferCodeImpl());

    // Assert
    verify(offerCodeDao).delete(isA(OfferCode.class));
    verify(offerCodeDao).offerCodeIsUsed(isA(OfferCode.class));
    assertTrue(actualDeleteOfferCodeResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferServiceImpl#setCustomerOfferDao(CustomerOfferDao)}
   *   <li>
   * {@link OfferServiceImpl#setFulfillmentGroupOfferProcessor(FulfillmentGroupOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setItemOfferProcessor(ItemOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setOfferCodeDao(OfferCodeDao)}
   *   <li>{@link OfferServiceImpl#setOfferDao(OfferDao)}
   *   <li>{@link OfferServiceImpl#setOrderOfferProcessor(OrderOfferProcessor)}
   *   <li>{@link OfferServiceImpl#setOrderService(OrderService)}
   *   <li>{@link OfferServiceImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceImpl#getCustomerOfferDao()}
   *   <li>{@link OfferServiceImpl#getFulfillmentGroupOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getItemOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getOfferCodeDao()}
   *   <li>{@link OfferServiceImpl#getOfferDao()}
   *   <li>{@link OfferServiceImpl#getOrderOfferProcessor()}
   *   <li>{@link OfferServiceImpl#getOrderService()}
   *   <li>{@link OfferServiceImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    CustomerOfferDaoImpl customerOfferDao = new CustomerOfferDaoImpl();

    // Act
    offerServiceImpl.setCustomerOfferDao(customerOfferDao);
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessor = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    offerServiceImpl.setFulfillmentGroupOfferProcessor(fulfillmentGroupOfferProcessor);
    ItemOfferProcessorImpl itemOfferProcessor = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setItemOfferProcessor(itemOfferProcessor);
    OfferCodeDaoImpl offerCodeDao = new OfferCodeDaoImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);
    OfferDaoImpl offerDao = new OfferDaoImpl();
    offerServiceImpl.setOfferDao(offerDao);
    FulfillmentGroupOfferProcessorImpl orderOfferProcessor = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    offerServiceImpl.setOrderOfferProcessor(orderOfferProcessor);
    OrderServiceImpl orderService = new OrderServiceImpl();
    offerServiceImpl.setOrderService(orderService);
    PromotableItemFactoryImpl promotableItemFactory = new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    offerServiceImpl.setPromotableItemFactory(promotableItemFactory);
    CustomerOfferDao actualCustomerOfferDao = offerServiceImpl.getCustomerOfferDao();
    FulfillmentGroupOfferProcessor actualFulfillmentGroupOfferProcessor = offerServiceImpl
        .getFulfillmentGroupOfferProcessor();
    ItemOfferProcessor actualItemOfferProcessor = offerServiceImpl.getItemOfferProcessor();
    OfferCodeDao actualOfferCodeDao = offerServiceImpl.getOfferCodeDao();
    OfferDao actualOfferDao = offerServiceImpl.getOfferDao();
    OrderOfferProcessor actualOrderOfferProcessor = offerServiceImpl.getOrderOfferProcessor();
    OrderService actualOrderService = offerServiceImpl.getOrderService();
    PromotableItemFactory actualPromotableItemFactory = offerServiceImpl.getPromotableItemFactory();

    // Assert that nothing has changed
    assertTrue(actualCustomerOfferDao instanceof CustomerOfferDaoImpl);
    assertTrue(actualOfferCodeDao instanceof OfferCodeDaoImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(customerOfferDao, actualCustomerOfferDao);
    assertSame(offerCodeDao, actualOfferCodeDao);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
    assertSame(fulfillmentGroupOfferProcessor, actualFulfillmentGroupOfferProcessor);
    assertSame(orderOfferProcessor, actualOrderOfferProcessor);
    assertSame(itemOfferProcessor, actualItemOfferProcessor);
    assertSame(orderService, actualOrderService);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodeById(Long)}.
   * <ul>
   *   <li>Then return {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodeById(Long)}
   */
  @Test
  public void testFindOfferCodeById_thenReturnOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    when(offerCodeDao.readOfferCodeById(Mockito.<Long>any())).thenReturn(offerCodeImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    OfferCode actualFindOfferCodeByIdResult = offerServiceImpl.findOfferCodeById(1L);

    // Assert
    verify(offerCodeDao).readOfferCodeById(eq(1L));
    assertSame(offerCodeImpl, actualFindOfferCodeByIdResult);
  }

  /**
   * Test {@link OfferServiceImpl#findOfferCodesByIds(Collection)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferCodesByIds(Collection)}
   */
  @Test
  public void testFindOfferCodesByIds_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeDaoImpl offerCodeDao = mock(OfferCodeDaoImpl.class);
    when(offerCodeDao.readOfferCodesByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferCodeDao(offerCodeDao);

    // Act
    List<OfferCode> actualFindOfferCodesByIdsResult = offerServiceImpl.findOfferCodesByIds(new ArrayList<>());

    // Assert
    verify(offerCodeDao).readOfferCodesByIds(isA(Collection.class));
    assertTrue(actualFindOfferCodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link OfferServiceImpl#findOfferById(Long)}.
   * <ul>
   *   <li>Then return {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferServiceImpl#findOfferById(Long)}
   */
  @Test
  public void testFindOfferById_thenReturnOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferDaoImpl offerDao = mock(OfferDaoImpl.class);
    OfferImpl offerImpl = new OfferImpl();
    when(offerDao.readOfferById(Mockito.<Long>any())).thenReturn(offerImpl);

    OfferServiceImpl offerServiceImpl = new OfferServiceImpl();
    offerServiceImpl.setOfferDao(offerDao);

    // Act
    Offer actualFindOfferByIdResult = offerServiceImpl.findOfferById(1L);

    // Assert
    verify(offerDao).readOfferById(eq(1L));
    assertSame(offerImpl, actualFindOfferByIdResult);
  }
}
