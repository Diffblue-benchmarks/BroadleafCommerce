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
package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl.PurgeErrorCache;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class ResourcePurgeServiceImplDiffblueTest {
  /**
   * Test CartPurgeParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ResourcePurgeServiceImpl.CartPurgeParams#CartPurgeParams(ResourcePurgeServiceImpl, Map)}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getBatchSize()}
   *   <li>
   * {@link ResourcePurgeServiceImpl.CartPurgeParams#getDateCreatedMinThreshold()}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getFailedRetryTime()}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getIsPreview()}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getNameArray()}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getStatusArray()}
   * </ul>
   */
  @Test
  public void testCartPurgeParamsGettersAndSetters() {
    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualCartPurgeParams = resourcePurgeServiceImpl.new CartPurgeParams(
        new HashMap<>());
    Long actualBatchSize = actualCartPurgeParams.getBatchSize();
    Date actualDateCreatedMinThreshold = actualCartPurgeParams.getDateCreatedMinThreshold();
    Long actualFailedRetryTime = actualCartPurgeParams.getFailedRetryTime();
    Boolean actualIsPreview = actualCartPurgeParams.getIsPreview();
    String[] actualNameArray = actualCartPurgeParams.getNameArray();

    // Assert
    assertNull(actualNameArray);
    assertNull(actualCartPurgeParams.getStatusArray());
    assertNull(actualIsPreview);
    assertNull(actualBatchSize);
    assertNull(actualFailedRetryTime);
    assertNull(actualDateCreatedMinThreshold);
  }

  /**
   * Test CustomerPurgeParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#CustomerPurgeParams(ResourcePurgeServiceImpl, Map)}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getBatchSize()}
   *   <li>
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#getDateCreatedMinThreshold()}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getFailedRetryTime()}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getIsDeactivated()}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getIsPreview()}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getIsRegistered()}
   * </ul>
   */
  @Test
  public void testCustomerPurgeParamsGettersAndSetters() {
    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act
    ResourcePurgeServiceImpl.CustomerPurgeParams actualCustomerPurgeParams = resourcePurgeServiceImpl.new CustomerPurgeParams(
        new HashMap<>());
    Long actualBatchSize = actualCustomerPurgeParams.getBatchSize();
    Date actualDateCreatedMinThreshold = actualCustomerPurgeParams.getDateCreatedMinThreshold();
    Long actualFailedRetryTime = actualCustomerPurgeParams.getFailedRetryTime();
    Boolean actualIsDeactivated = actualCustomerPurgeParams.getIsDeactivated();
    Boolean actualIsPreview = actualCustomerPurgeParams.getIsPreview();

    // Assert
    assertNull(actualIsDeactivated);
    assertNull(actualIsPreview);
    assertNull(actualCustomerPurgeParams.getIsRegistered());
    assertNull(actualBatchSize);
    assertNull(actualFailedRetryTime);
    assertNull(actualDateCreatedMinThreshold);
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  public void testPurgeCarts_whenHashMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCarts(new HashMap<>()));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  public void testNotifyCarts_whenHashMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.notifyCarts(new HashMap<>()));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  public void testPurgeCustomers_whenHashMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCustomers(new HashMap<>()));
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCartsInErrorToIgnore(CartPurgeParams)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCartsInErrorToIgnore(ResourcePurgeServiceImpl.CartPurgeParams)}
   */
  @Test
  public void testGetCartsInErrorToIgnore_givenOne_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CartPurgeParams purgeParams = mock(ResourcePurgeServiceImpl.CartPurgeParams.class);
    when(purgeParams.getFailedRetryTime()).thenReturn(1L);

    // Act
    Set<Long> actualCartsInErrorToIgnore = resourcePurgeServiceImpl.getCartsInErrorToIgnore(purgeParams);

    // Assert
    verify(purgeParams).getFailedRetryTime();
    assertTrue(actualCartsInErrorToIgnore.isEmpty());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>Given {@code 42 Main St}.</li>
   *   <li>Then return {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_given42MainSt_thenReturn42MainSt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();
    NullOrderImpl cart = mock(NullOrderImpl.class);
    when(cart.getEmailAddress()).thenReturn("42 Main St");

    // Act
    String actualEmailForCart = resourcePurgeServiceImpl.getEmailForCart(cart);

    // Assert
    verify(cart, atLeast(1)).getEmailAddress();
    assertEquals("42 Main St", actualEmailForCart);
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>Given {@code Cart}.</li>
   *   <li>When {@link OrderImpl} (default constructor) EmailAddress is
   * {@code Cart}.</li>
   *   <li>Then return {@code Cart}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_givenCart_whenOrderImplEmailAddressIsCart_thenReturnCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress("Cart");
    cart.setCustomer(null);

    // Act and Assert
    assertEquals("Cart", resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   *   <li>Then return {@code Cart}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_givenCustomerImplAuditableIsAuditable_thenReturnCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

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

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("Cart");

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);
    cart.setCustomer(customer);

    // Act and Assert
    assertEquals("Cart", resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_givenCustomerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);
    cart.setCustomer(new CustomerImpl());

    // Act and Assert
    assertNull(resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act and Assert
    assertNull(resourcePurgeServiceImpl.getEmailForCart(new NullOrderImpl()));
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCustomersInErrorToIgnore(CustomerPurgeParams)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCustomersInErrorToIgnore(ResourcePurgeServiceImpl.CustomerPurgeParams)}
   */
  @Test
  public void testGetCustomersInErrorToIgnore_givenOne_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CustomerPurgeParams purgeParams = mock(ResourcePurgeServiceImpl.CustomerPurgeParams.class);
    when(purgeParams.getFailedRetryTime()).thenReturn(1L);

    // Act
    Set<Long> actualCustomersInErrorToIgnore = resourcePurgeServiceImpl.getCustomersInErrorToIgnore(purgeParams);

    // Assert
    verify(purgeParams).getFailedRetryTime();
    assertTrue(actualCustomersInErrorToIgnore.isEmpty());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#add(Long)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.PurgeErrorCache#add(Long)}
   */
  @Test
  public void testPurgeErrorCacheAdd() {
    // Arrange
    ResourcePurgeServiceImpl.PurgeErrorCache purgeErrorCache = (new ResourcePurgeServiceImpl()).new PurgeErrorCache();
    purgeErrorCache.add(1L);

    // Act and Assert
    assertNull(purgeErrorCache.add(1L));
    assertEquals(1, purgeErrorCache.size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#add(Long)}.
   * <ul>
   *   <li>Given {@link PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)}
   * with this$0 is {@link ResourcePurgeServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.PurgeErrorCache#add(Long)}
   */
  @Test
  public void testPurgeErrorCacheAdd_givenPurgeErrorCacheWithThis$0IsResourcePurgeServiceImpl() {
    // Arrange
    ResourcePurgeServiceImpl.PurgeErrorCache purgeErrorCache = (new ResourcePurgeServiceImpl()).new PurgeErrorCache();

    // Act and Assert
    assertNull(purgeErrorCache.add(1L));
    assertEquals(1, purgeErrorCache.size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#getEntriesSince(long)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.PurgeErrorCache#getEntriesSince(long)}
   */
  @Test
  public void testPurgeErrorCacheGetEntriesSince() {
    // Arrange
    ResourcePurgeServiceImpl.PurgeErrorCache purgeErrorCache = (new ResourcePurgeServiceImpl()).new PurgeErrorCache();

    // Act
    Set<Long> actualEntriesSince = purgeErrorCache.getEntriesSince(1L);

    // Assert
    assertEquals(0, purgeErrorCache.size());
    assertTrue(actualEntriesSince.isEmpty());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#getEntriesSince(long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.PurgeErrorCache#getEntriesSince(long)}
   */
  @Test
  public void testPurgeErrorCacheGetEntriesSince_whenMax_value() {
    // Arrange
    ResourcePurgeServiceImpl.PurgeErrorCache purgeErrorCache = (new ResourcePurgeServiceImpl()).new PurgeErrorCache();
    purgeErrorCache.add(1L);

    // Act
    Set<Long> actualEntriesSince = purgeErrorCache.getEntriesSince(Long.MAX_VALUE);

    // Assert
    assertEquals(0, purgeErrorCache.size());
    assertTrue(actualEntriesSince.isEmpty());
  }

  /**
   * Test PurgeErrorCache
   * {@link PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)}
   */
  @Test
  public void testPurgeErrorCacheNewPurgeErrorCache() {
    // Arrange, Act and Assert
    assertEquals(0, ((new ResourcePurgeServiceImpl()).new PurgeErrorCache()).size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#size()}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.PurgeErrorCache#size()}
   */
  @Test
  public void testPurgeErrorCacheSize() {
    // Arrange, Act and Assert
    assertEquals(0, ((new ResourcePurgeServiceImpl()).new PurgeErrorCache()).size());
  }
}
