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
package org.broadleafcommerce.core.pricing.service.tax.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.i18n.domain.ISOCountry;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.common.i18n.service.type.ISOCodeStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFee;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupFeeImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.domain.TaxDetail;
import org.broadleafcommerce.core.order.domain.TaxDetailImpl;
import org.broadleafcommerce.core.order.domain.TaxType;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.TaxException;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SimpleTaxProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleTaxProviderDiffblueTest {
  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  @Autowired
  private SimpleTaxProvider simpleTaxProvider;

  /**
   * Test {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}.
   * <ul>
   *   <li>When {@link ModuleConfiguration}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}
   */
  @Test
  public void testCanRespond_whenModuleConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SimpleTaxProvider()).canRespond(mock(ModuleConfiguration.class)));
  }

  /**
   * Test {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}
   */
  @Test
  public void testCanRespond_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new SimpleTaxProvider()).canRespond(null));
  }

  /**
   * Test {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}.
   * <ul>
   *   <li>When {@link SiteMapConfigurationImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}
   */
  @Test
  public void testCanRespond_whenSiteMapConfigurationImpl_thenReturnFalse() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertFalse(simpleTaxProvider.canRespond(new SiteMapConfigurationImpl()));
  }

  /**
   * Test
   * {@link SimpleTaxProvider#calculateTaxForOrder(Order, ModuleConfiguration)}.
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} (default constructor).</li>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#calculateTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  public void testCalculateTaxForOrder_givenSimpleTaxProvider_thenReturnOrderImpl() throws TaxException {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

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
    assertSame(order, simpleTaxProvider.calculateTaxForOrder(order, new SiteMapConfigurationImpl()));
  }

  /**
   * Test
   * {@link SimpleTaxProvider#calculateTaxForOrder(Order, ModuleConfiguration)}.
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} (default constructor).</li>
   *   <li>Then return {@link OrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#calculateTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  public void testCalculateTaxForOrder_givenSimpleTaxProvider_thenReturnOrderImpl2() throws TaxException {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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

    // Act
    Order actualCalculateTaxForOrderResult = simpleTaxProvider.calculateTaxForOrder(order,
        new SiteMapConfigurationImpl());

    // Assert
    assertTrue(actualCalculateTaxForOrderResult instanceof OrderImpl);
    assertSame(fulfillmentGroups, actualCalculateTaxForOrderResult.getFulfillmentGroups());
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    when(addressImpl.getState()).thenReturn(new StateImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl).getState();
    verify(addressImpl).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes3() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes4() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes5() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes6() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes7() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn(null);
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    when(addressImpl.getState()).thenReturn(new StateImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl).getState();
    verify(addressImpl).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_givenAddressImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(new AddressImpl());
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getCity()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_givenAddressImplGetCityReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn(null);
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPostalCode()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_givenAddressImplGetPostalCodeReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn(null);
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_givenArrayList() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(new ArrayList<>());

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroup).getFulfillmentGroupItems();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#isTaxable()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_givenBundleOrderItemImplIsTaxableReturnFalse() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(false);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} {@link ISOCountryImpl#getName()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_givenISOCountryImplGetNameReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    ISOCountryImpl isoCountryImpl = mock(ISOCountryImpl.class);
    when(isoCountryImpl.getName()).thenReturn(null);
    when(isoCountryImpl.getAlpha2()).thenReturn("Alpha2");
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(isoCountryImpl);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(isoCountryImpl, atLeast(1)).getAlpha2();
    verify(isoCountryImpl).getName();
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_givenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(null);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link ISOCountryImpl#getAlpha2()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_thenCallsGetAlpha2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    ISOCountryImpl isoCountryImpl = mock(ISOCountryImpl.class);
    when(isoCountryImpl.getName()).thenReturn("Name");
    when(isoCountryImpl.getAlpha2()).thenReturn("Alpha2");
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(isoCountryImpl);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(isoCountryImpl, atLeast(1)).getAlpha2();
    verify(isoCountryImpl, atLeast(1)).getName();
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#getCountry()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes_thenCallsGetCountry() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(true);
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupItemImpl.getTotalItemTaxableAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(null);
    when(addressImpl.getCountry()).thenReturn(new CountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getTaxes();
    verify(fulfillmentGroupItemImpl).getTotalItemTaxableAmount();
    verify(addressImpl).getCity();
    verify(addressImpl).getCountry();
    verify(addressImpl).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes3() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes4() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenAddressImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(new AddressImpl());
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenArrayList() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(new ArrayList<>());

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroup).getFulfillmentGroupFees();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupFeeImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenArrayListAddFulfillmentGroupFeeImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(new FulfillmentGroupFeeImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroup).getFulfillmentGroupFees();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then calls {@link AddressImpl#getCity()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenBigDecimalWith23_thenCallsGetCity() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    Money amount = new Money();
    taxDetailList.add(new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3")));
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(null);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} (default constructor).</li>
   *   <li>Then calls {@link AddressImpl#getCity()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenSimpleTaxProvider_thenCallsGetCity() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return
   * {@link TaxType#CITY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenTaxDetailImplGetTypeReturnCity() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(taxDetailImpl);
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(taxDetailImpl).getType();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return
   * {@link TaxType#COMBINED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenTaxDetailImplGetTypeReturnCombined() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.COMBINED);

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(taxDetailImpl);
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(taxDetailImpl).getType();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return
   * {@link TaxType#TaxType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenTaxDetailImplGetTypeReturnTaxType() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(new TaxType());

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(taxDetailImpl);
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(taxDetailImpl).getType();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return
   * {@link TaxType}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_givenTaxDetailImplGetTypeReturnTaxType2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(mock(TaxType.class));

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(taxDetailImpl);
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(taxDetailImpl).getType();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#getState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_thenCallsGetState() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(new ArrayList<>());
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    when(addressImpl.getState()).thenReturn(new StateImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl).getState();
    verify(addressImpl).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link Money#multiply(BigDecimal)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_thenCallsMultiply() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    doNothing().when(taxDetailImpl).setAmount(Mockito.<Money>any());
    doNothing().when(taxDetailImpl).setRate(Mockito.<BigDecimal>any());
    when(taxDetailImpl.getType()).thenReturn(TaxType.COMBINED);

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(taxDetailImpl);
    Money money = mock(Money.class);
    when(money.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(money);
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(money).multiply(isA(BigDecimal.class));
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(taxDetailImpl).getType();
    verify(taxDetailImpl).setAmount(isA(Money.class));
    verify(taxDetailImpl).setRate(isA(BigDecimal.class));
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link TaxDetailImpl#setAmount(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes_thenCallsSetAmount() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    doNothing().when(taxDetailImpl).setAmount(Mockito.<Money>any());
    doNothing().when(taxDetailImpl).setRate(Mockito.<BigDecimal>any());
    when(taxDetailImpl.getType()).thenReturn(TaxType.COMBINED);

    ArrayList<TaxDetail> taxDetailList = new ArrayList<>();
    taxDetailList.add(taxDetailImpl);
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = mock(FulfillmentGroupFeeImpl.class);
    when(fulfillmentGroupFeeImpl.getTaxes()).thenReturn(taxDetailList);
    when(fulfillmentGroupFeeImpl.getAmount()).thenReturn(new Money());
    when(fulfillmentGroupFeeImpl.isTaxable()).thenReturn(true);

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFeeList = new ArrayList<>();
    fulfillmentGroupFeeList.add(fulfillmentGroupFeeImpl);
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getCity()).thenReturn("Oxford");
    when(addressImpl.getPostalCode()).thenReturn("Postal Code");
    when(addressImpl.getStateProvinceRegion()).thenReturn("us-east-2");
    when(addressImpl.getIsoCountryAlpha2()).thenReturn(new ISOCountryImpl());
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupFees()).thenReturn(fulfillmentGroupFeeList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(fulfillmentGroupFeeImpl).getAmount();
    verify(fulfillmentGroupFeeImpl).getTaxes();
    verify(fulfillmentGroupFeeImpl).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupFees();
    verify(taxDetailImpl).getType();
    verify(taxDetailImpl).setAmount(isA(Money.class));
    verify(taxDetailImpl).setRate(isA(BigDecimal.class));
    verify(addressImpl).getCity();
    verify(addressImpl, atLeast(1)).getIsoCountryAlpha2();
    verify(addressImpl).getPostalCode();
    verify(addressImpl, atLeast(1)).getStateProvinceRegion();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupTaxes_givenStateGetNameReturnName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    State state = mock(State.class);
    when(state.getName()).thenReturn("Name");
    when(state.getAbbreviation()).thenReturn("Abbreviation");

    AddressImpl address = new AddressImpl();
    address.setState(state);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    simpleTaxProvider.handleFulfillmentGroupTaxes(fulfillmentGroup);

    // Assert that nothing has changed
    verify(state, atLeast(1)).getAbbreviation();
    verify(state, atLeast(1)).getName();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupTaxes_givenStateGetNameReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    State state = mock(State.class);
    when(state.getName()).thenReturn(null);
    when(state.getAbbreviation()).thenReturn("Abbreviation");

    AddressImpl address = new AddressImpl();
    address.setState(state);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    simpleTaxProvider.handleFulfillmentGroupTaxes(fulfillmentGroup);

    // Assert that nothing has changed
    verify(state, atLeast(1)).getAbbreviation();
    verify(state).getName();
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is
   * {@link TaxDetailImpl#TaxDetailImpl()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  public void testApplyTaxFactor_thenArrayListFirstIsTaxDetailImpl() {
    // Arrange
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<TaxDetail>>any()))
        .thenReturn(taxDetailImpl);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    BigDecimal taxFactor = new BigDecimal("2.3");

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, new Money());

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.order.domain.TaxDetail"),
        isA(Class.class));
    assertEquals(1, taxes.size());
    assertSame(taxDetailImpl, taxes.get(0));
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  public void testApplyTaxFactor_whenArrayList_thenArrayListSizeIsOne() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    doNothing().when(taxDetailImpl).setAmount(Mockito.<Money>any());
    doNothing().when(taxDetailImpl).setRate(Mockito.<BigDecimal>any());
    doNothing().when(taxDetailImpl).setType(Mockito.<TaxType>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<TaxDetail>>any()))
        .thenReturn(taxDetailImpl);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    BigDecimal taxFactor = new BigDecimal("2.3");
    Money taxMultiplier = new Money();

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.order.domain.TaxDetail"),
        isA(Class.class));
    verify(taxDetailImpl).setAmount(isA(Money.class));
    verify(taxDetailImpl).setRate(isA(BigDecimal.class));
    verify(taxDetailImpl).setType(isA(TaxType.class));
    assertEquals(1, taxes.size());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = taxMultiplier.getAmount();
    assertEquals(expectedAmount, amount);
    Money absResult = taxMultiplier.abs();
    assertSame(amount, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(amount, absResult2.getAmount());
    Money absResult3 = absResult2.abs();
    assertSame(amount, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(amount, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(amount, absResult5.getAmount());
    assertSame(amount, absResult5.abs().getAmount());
    Money zeroResult = taxMultiplier.zero();
    Money absResult6 = zeroResult.abs();
    Money absResult7 = absResult6.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    assertSame(amount, absResult9.abs().getAmount());
    assertSame(amount, absResult9.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult10 = zeroResult2.abs();
    Money absResult11 = absResult10.abs();
    Money absResult12 = absResult11.abs();
    assertSame(amount, absResult12.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult13 = zeroResult3.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(amount, absResult15.abs().getAmount());
    assertSame(amount, absResult8.getAmount());
    assertSame(amount, absResult12.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult16 = zeroResult4.abs();
    Money absResult17 = absResult16.abs();
    assertSame(amount, absResult17.abs().getAmount());
    Money zeroResult5 = absResult6.zero();
    Money absResult18 = zeroResult5.abs();
    Money absResult19 = absResult18.abs();
    assertSame(amount, absResult19.abs().getAmount());
    assertSame(amount, absResult15.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult20 = zeroResult6.abs();
    Money absResult21 = absResult20.abs();
    assertSame(amount, absResult21.abs().getAmount());
    assertSame(amount, absResult7.getAmount());
    assertSame(amount, absResult11.getAmount());
    assertSame(amount, absResult17.getAmount());
    Money zeroResult7 = absResult3.zero();
    Money absResult22 = zeroResult7.abs();
    assertSame(amount, absResult22.abs().getAmount());
    Money zeroResult8 = absResult7.zero();
    Money absResult23 = zeroResult8.abs();
    assertSame(amount, absResult23.abs().getAmount());
    assertSame(amount, absResult19.getAmount());
    Money zeroResult9 = absResult10.zero();
    Money absResult24 = zeroResult9.abs();
    assertSame(amount, absResult24.abs().getAmount());
    Money zeroResult10 = absResult13.zero();
    Money absResult25 = zeroResult10.abs();
    assertSame(amount, absResult25.abs().getAmount());
    assertSame(amount, absResult14.getAmount());
    assertSame(amount, absResult21.getAmount());
    Money zeroResult11 = zeroResult4.zero();
    Money absResult26 = zeroResult11.abs();
    assertSame(amount, absResult26.abs().getAmount());
    Money zeroResult12 = zeroResult5.zero();
    Money absResult27 = zeroResult12.abs();
    assertSame(amount, absResult27.abs().getAmount());
    Money zeroResult13 = zeroResult3.zero();
    Money absResult28 = zeroResult13.abs();
    assertSame(amount, absResult28.abs().getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult29 = zeroResult14.abs();
    assertSame(amount, absResult29.abs().getAmount());
    assertSame(amount, absResult6.getAmount());
    assertSame(amount, absResult10.getAmount());
    assertSame(amount, absResult16.getAmount());
    assertSame(amount, absResult22.getAmount());
    Money zeroResult15 = absResult4.zero();
    assertSame(amount, zeroResult15.abs().getAmount());
    Money zeroResult16 = absResult8.zero();
    assertSame(amount, zeroResult16.abs().getAmount());
    assertSame(amount, absResult23.getAmount());
    Money zeroResult17 = absResult11.zero();
    assertSame(amount, zeroResult17.abs().getAmount());
    Money zeroResult18 = absResult14.zero();
    assertSame(amount, zeroResult18.abs().getAmount());
    assertSame(amount, absResult18.getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult19 = absResult16.zero();
    assertSame(amount, zeroResult19.abs().getAmount());
    Money zeroResult20 = absResult18.zero();
    assertSame(amount, zeroResult20.abs().getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult21 = absResult20.zero();
    assertSame(amount, zeroResult21.abs().getAmount());
    assertSame(amount, absResult13.getAmount());
    assertSame(amount, absResult20.getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult22 = zeroResult7.zero();
    assertSame(amount, zeroResult22.abs().getAmount());
    Money zeroResult23 = zeroResult8.zero();
    assertSame(amount, zeroResult23.abs().getAmount());
    assertSame(amount, absResult27.getAmount());
    Money zeroResult24 = zeroResult9.zero();
    assertSame(amount, zeroResult24.abs().getAmount());
    Money zeroResult25 = zeroResult10.zero();
    assertSame(amount, zeroResult25.abs().getAmount());
    assertSame(amount, absResult28.getAmount());
    assertSame(amount, absResult29.getAmount());
    Money zeroResult26 = zeroResult11.zero();
    assertSame(amount, zeroResult26.abs().getAmount());
    Money zeroResult27 = zeroResult12.zero();
    assertSame(amount, zeroResult27.abs().getAmount());
    Money zeroResult28 = zeroResult13.zero();
    assertSame(amount, zeroResult28.abs().getAmount());
    Money zeroResult29 = zeroResult14.zero();
    assertSame(amount, zeroResult29.abs().getAmount());
    assertSame(amount, zeroResult.getAmount());
    assertSame(amount, zeroResult2.getAmount());
    assertSame(amount, zeroResult4.getAmount());
    assertSame(amount, zeroResult7.getAmount());
    assertSame(amount, zeroResult15.getAmount());
    assertSame(amount, absResult5.zero().getAmount());
    assertSame(amount, absResult9.zero().getAmount());
    assertSame(amount, zeroResult16.getAmount());
    assertSame(amount, absResult12.zero().getAmount());
    assertSame(amount, absResult15.zero().getAmount());
    assertSame(amount, zeroResult8.getAmount());
    assertSame(amount, zeroResult17.getAmount());
    assertSame(amount, absResult17.zero().getAmount());
    assertSame(amount, absResult19.zero().getAmount());
    assertSame(amount, zeroResult18.getAmount());
    assertSame(amount, absResult21.zero().getAmount());
    assertSame(amount, zeroResult5.getAmount());
    assertSame(amount, zeroResult9.getAmount());
    assertSame(amount, zeroResult19.getAmount());
    assertSame(amount, absResult22.zero().getAmount());
    assertSame(amount, absResult23.zero().getAmount());
    assertSame(amount, zeroResult20.getAmount());
    assertSame(amount, absResult24.zero().getAmount());
    assertSame(amount, absResult25.zero().getAmount());
    assertSame(amount, zeroResult10.getAmount());
    assertSame(amount, zeroResult21.getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, absResult27.zero().getAmount());
    assertSame(amount, absResult28.zero().getAmount());
    assertSame(amount, absResult29.zero().getAmount());
    assertSame(amount, zeroResult3.getAmount());
    assertSame(amount, zeroResult6.getAmount());
    assertSame(amount, zeroResult11.getAmount());
    assertSame(amount, zeroResult22.getAmount());
    assertSame(amount, zeroResult15.zero().getAmount());
    assertSame(amount, zeroResult16.zero().getAmount());
    assertSame(amount, zeroResult23.getAmount());
    assertSame(amount, zeroResult17.zero().getAmount());
    assertSame(amount, zeroResult18.zero().getAmount());
    assertSame(amount, zeroResult12.getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult19.zero().getAmount());
    assertSame(amount, zeroResult20.zero().getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, zeroResult21.zero().getAmount());
    assertSame(amount, zeroResult13.getAmount());
    assertSame(amount, zeroResult14.getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult22.zero().getAmount());
    assertSame(amount, zeroResult23.zero().getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, zeroResult24.zero().getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult26.zero().getAmount());
    assertSame(amount, zeroResult27.zero().getAmount());
    assertSame(amount, zeroResult28.zero().getAmount());
    assertSame(amount, zeroResult29.zero().getAmount());
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   * <p>
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(new TaxType("COMBINED", "CITY"));

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    // Act
    simpleTaxProvider.findExistingTaxDetail(taxes);

    // Assert
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail_givenBigDecimalWith23() {
    // Arrange
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    Money amount = new Money();
    taxes.add(new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3")));

    // Act and Assert
    assertNull(simpleTaxProvider.findExistingTaxDetail(taxes));
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return
   * {@link TaxType#CITY}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail_givenTaxDetailImplGetTypeReturnCity_thenReturnNull() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    // Act
    TaxDetail actualFindExistingTaxDetailResult = simpleTaxProvider.findExistingTaxDetail(taxes);

    // Assert
    verify(taxDetailImpl).getType();
    assertNull(actualFindExistingTaxDetailResult);
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return
   * {@link TaxType#COMBINED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail_givenTaxDetailImplGetTypeReturnCombined() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.COMBINED);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    // Act
    simpleTaxProvider.findExistingTaxDetail(taxes);

    // Assert
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return
   * {@link TaxType#TaxType()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail_givenTaxDetailImplGetTypeReturnTaxType_thenReturnNull() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(new TaxType());

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    // Act
    TaxDetail actualFindExistingTaxDetailResult = simpleTaxProvider.findExistingTaxDetail(taxes);

    // Assert
    verify(taxDetailImpl).getType();
    assertNull(actualFindExistingTaxDetailResult);
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return
   * {@link TaxType}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail_givenTaxDetailImplGetTypeReturnTaxType_thenReturnNull2() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(mock(TaxType.class));

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    // Act
    TaxDetail actualFindExistingTaxDetailResult = simpleTaxProvider.findExistingTaxDetail(taxes);

    // Assert
    verify(taxDetailImpl).getType();
    assertNull(actualFindExistingTaxDetailResult);
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.findExistingTaxDetail(new ArrayList<>()));
  }

  /**
   * Test {@link SimpleTaxProvider#commitTaxForOrder(Order, ModuleConfiguration)}.
   * <ul>
   *   <li>When {@link ModuleConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#commitTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  public void testCommitTaxForOrder_whenModuleConfiguration() throws TaxException {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act
    Order actualCommitTaxForOrderResult = simpleTaxProvider.commitTaxForOrder(new NullOrderImpl(),
        mock(ModuleConfiguration.class));

    // Assert
    assertTrue(actualCommitTaxForOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualCommitTaxForOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualCommitTaxForOrderResult.getSubTotal());
  }

  /**
   * Test {@link SimpleTaxProvider#commitTaxForOrder(Order, ModuleConfiguration)}.
   * <ul>
   *   <li>When {@link SiteMapConfigurationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#commitTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  public void testCommitTaxForOrder_whenSiteMapConfigurationImpl() throws TaxException {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCommitTaxForOrderResult = simpleTaxProvider.commitTaxForOrder(order, new SiteMapConfigurationImpl());

    // Assert
    assertTrue(actualCommitTaxForOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualCommitTaxForOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualCommitTaxForOrderResult.getSubTotal());
  }

  /**
   * Test {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}
   */
  @Test
  public void testLookupPostalCodeRate_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, Double> postalCodeTaxRateMap = new HashMap<>();
    postalCodeTaxRateMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleTaxProvider.lookupPostalCodeRate(postalCodeTaxRateMap, "Postal Code"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}
   */
  @Test
  public void testLookupPostalCodeRate_whenHashMap() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupPostalCodeRate(new HashMap<>(), "Postal Code"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}
   */
  @Test
  public void testLookupPostalCodeRate_whenNull() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupPostalCodeRate(new HashMap<>(), null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCityRate(Map, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCityRate(Map, String)}
   */
  @Test
  public void testLookupCityRate_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, Double> cityTaxRateMap = new HashMap<>();
    cityTaxRateMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCityRate(cityTaxRateMap, "Oxford"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCityRate(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCityRate(Map, String)}
   */
  @Test
  public void testLookupCityRate_whenHashMap() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupCityRate(new HashMap<>(), "Oxford"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCityRate(Map, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCityRate(Map, String)}
   */
  @Test
  public void testLookupCityRate_whenNull() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupCityRate(new HashMap<>(), null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with
   * {@code stateTaxRateMap}, {@code stateProvinceRegion}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_givenFoo() {
    // Arrange
    HashMap<String, Double> stateTaxRateMap = new HashMap<>();
    stateTaxRateMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(stateTaxRateMap, "us-east-2"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with
   * {@code stateTaxRateMap}, {@code stateProvinceRegion}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), ""));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with
   * {@code stateTaxRateMap}, {@code stateProvinceRegion}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_whenNull() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), (String) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with
   * {@code stateTaxRateMap}, {@code stateProvinceRegion}.
   * <ul>
   *   <li>When {@code us-east-2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_whenUsEast2() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), "us-east-2"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with
   * {@code stateTaxRateMap}, {@code state}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return doubleValue is {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapState_given42_thenReturnDoubleValueIs05() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    HashMap<String, Double> stateTaxRateMap = new HashMap<>();
    stateTaxRateMap.put("42", 0.5d);
    State state = mock(State.class);
    when(state.getAbbreviation()).thenReturn("42");

    // Act
    Double actualLookupStateRateResult = simpleTaxProvider.lookupStateRate(stateTaxRateMap, state);

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    assertEquals(0.5d, actualLookupStateRateResult.doubleValue(), 0.0);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with
   * {@code stateTaxRateMap}, {@code state}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then calls {@link State#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapState_givenName_thenCallsGetName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> stateTaxRateMap = new HashMap<>();
    State state = mock(State.class);
    when(state.getName()).thenReturn("Name");
    when(state.getAbbreviation()).thenReturn("Abbreviation");

    // Act
    Double actualLookupStateRateResult = simpleTaxProvider.lookupStateRate(stateTaxRateMap, state);

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state, atLeast(1)).getName();
    assertNull(actualLookupStateRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with
   * {@code stateTaxRateMap}, {@code state}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link StateImpl} (default constructor) Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapState_givenNull_whenStateImplNameIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> stateTaxRateMap = new HashMap<>();

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("MD");
    state.setName(null);

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(stateTaxRateMap, state));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with
   * {@code stateTaxRateMap}, {@code state}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapState_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SimpleTaxProvider()).lookupStateRate(null, (State) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with
   * {@code stateTaxRateMap}, {@code state}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapState_whenNull_thenReturnNull2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), (State) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with
   * {@code stateTaxRateMap}, {@code state}.
   * <ul>
   *   <li>When {@link StateImpl} (default constructor) Name is {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapState_whenStateImplNameIsMd() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> stateTaxRateMap = new HashMap<>();

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("MD");
    state.setName("MD");

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(stateTaxRateMap, state));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with
   * {@code stateTaxRateMap}, {@code state}.
   * <ul>
   *   <li>When {@link StateImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRateWithStateTaxRateMapState_whenStateImpl_thenReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> stateTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(stateTaxRateMap, new StateImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with
   * {@code countryTaxRateMap}, {@code country}.
   * <ul>
   *   <li>Given {@code GB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapCountry_givenGb() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation("GB");

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, country));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with
   * {@code countryTaxRateMap}, {@code country}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapCountry_givenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();
    Country country = mock(Country.class);
    when(country.getName()).thenReturn(null);
    when(country.getAbbreviation()).thenReturn("Abbreviation");

    // Act
    Double actualLookupCountryRateResult = simpleTaxProvider.lookupCountryRate(countryTaxRateMap, country);

    // Assert
    verify(country, atLeast(1)).getAbbreviation();
    verify(country).getName();
    assertNull(actualLookupCountryRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with
   * {@code countryTaxRateMap}, {@code country}.
   * <ul>
   *   <li>Then return doubleValue is {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapCountry_thenReturnDoubleValueIs05() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    HashMap<String, Double> countryTaxRateMap = new HashMap<>();
    countryTaxRateMap.put("42", 0.5d);
    Country country = mock(Country.class);
    when(country.getAbbreviation()).thenReturn("42");

    // Act
    Double actualLookupCountryRateResult = simpleTaxProvider.lookupCountryRate(countryTaxRateMap, country);

    // Assert
    verify(country, atLeast(1)).getAbbreviation();
    assertEquals(0.5d, actualLookupCountryRateResult.doubleValue(), 0.0);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with
   * {@code countryTaxRateMap}, {@code country}.
   * <ul>
   *   <li>When {@link Country} {@link Country#getName()} return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapCountry_whenCountryGetNameReturnName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();
    Country country = mock(Country.class);
    when(country.getName()).thenReturn("Name");
    when(country.getAbbreviation()).thenReturn("Abbreviation");

    // Act
    Double actualLookupCountryRateResult = simpleTaxProvider.lookupCountryRate(countryTaxRateMap, country);

    // Assert
    verify(country, atLeast(1)).getAbbreviation();
    verify(country, atLeast(1)).getName();
    assertNull(actualLookupCountryRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with
   * {@code countryTaxRateMap}, {@code country}.
   * <ul>
   *   <li>When {@link CountryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapCountry_whenCountryImpl_thenReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, new CountryImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with
   * {@code countryTaxRateMap}, {@code country}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapCountry_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SimpleTaxProvider()).lookupCountryRate(null, (Country) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with
   * {@code countryTaxRateMap}, {@code country}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapCountry_whenNull_thenReturnNull2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(new HashMap<>(), (Country) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with
   * {@code countryTaxRateMap}, {@code isoCountry}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then calls {@link ISOCountry#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_givenName_thenCallsGetName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();
    ISOCountry isoCountry = mock(ISOCountry.class);
    when(isoCountry.getName()).thenReturn("Name");
    when(isoCountry.getAlpha2()).thenReturn("Alpha2");

    // Act
    Double actualLookupCountryRateResult = simpleTaxProvider.lookupCountryRate(countryTaxRateMap, isoCountry);

    // Assert
    verify(isoCountry, atLeast(1)).getAlpha2();
    verify(isoCountry, atLeast(1)).getName();
    assertNull(actualLookupCountryRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with
   * {@code countryTaxRateMap}, {@code isoCountry}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_givenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    ISOCountryImpl isoCountry = new ISOCountryImpl();
    isoCountry.setAlpha3("Alpha3");
    isoCountry.setNumericCode(10);
    isoCountry.setStatus(new ISOCodeStatusType("Type", "Friendly Type"));
    isoCountry.setAlpha2("GB");
    isoCountry.setName(null);

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, isoCountry));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with
   * {@code countryTaxRateMap}, {@code isoCountry}.
   * <ul>
   *   <li>Then return doubleValue is {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_thenReturnDoubleValueIs05() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    HashMap<String, Double> countryTaxRateMap = new HashMap<>();
    countryTaxRateMap.put("42", 0.5d);
    ISOCountry isoCountry = mock(ISOCountry.class);
    when(isoCountry.getAlpha2()).thenReturn("42");

    // Act
    Double actualLookupCountryRateResult = simpleTaxProvider.lookupCountryRate(countryTaxRateMap, isoCountry);

    // Assert
    verify(isoCountry, atLeast(1)).getAlpha2();
    assertEquals(0.5d, actualLookupCountryRateResult.doubleValue(), 0.0);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with
   * {@code countryTaxRateMap}, {@code isoCountry}.
   * <ul>
   *   <li>When {@link ISOCountryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_whenISOCountryImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, new ISOCountryImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with
   * {@code countryTaxRateMap}, {@code isoCountry}.
   * <ul>
   *   <li>When {@link ISOCountryImpl} (default constructor) Name is
   * {@code GB}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_whenISOCountryImplNameIsGb() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    ISOCountryImpl isoCountry = new ISOCountryImpl();
    isoCountry.setAlpha3("Alpha3");
    isoCountry.setNumericCode(10);
    isoCountry.setStatus(new ISOCodeStatusType("Type", "Friendly Type"));
    isoCountry.setAlpha2("GB");
    isoCountry.setName("GB");

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, isoCountry));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with
   * {@code countryTaxRateMap}, {@code isoCountry}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SimpleTaxProvider()).lookupCountryRate(null, (ISOCountry) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with
   * {@code countryTaxRateMap}, {@code isoCountry}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_whenNull_thenReturnNull2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(new HashMap<>(), (ISOCountry) null));
  }

  /**
   * Test {@link SimpleTaxProvider#isItemTaxable(FulfillmentGroupItem)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#isItemTaxable(FulfillmentGroupItem)}
   */
  @Test
  public void testIsItemTaxable_givenBundleOrderItemImpl_thenReturnTrue() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    FulfillmentGroupItemImpl item = new FulfillmentGroupItemImpl();
    item.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertTrue(simpleTaxProvider.isItemTaxable(item));
  }

  /**
   * Test {@link SimpleTaxProvider#isFeeTaxable(FulfillmentGroupFee)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#isFeeTaxable(FulfillmentGroupFee)}
   */
  @Test
  public void testIsFeeTaxable_givenTrue_thenReturnTrue() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    FulfillmentGroupFeeImpl fee = new FulfillmentGroupFeeImpl();
    fee.setTaxable(true);

    // Act and Assert
    assertTrue(simpleTaxProvider.isFeeTaxable(fee));
  }

  /**
   * Test {@link SimpleTaxProvider#isFeeTaxable(FulfillmentGroupFee)}.
   * <ul>
   *   <li>When {@link FulfillmentGroupFeeImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#isFeeTaxable(FulfillmentGroupFee)}
   */
  @Test
  public void testIsFeeTaxable_whenFulfillmentGroupFeeImpl_thenReturnFalse() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertFalse(simpleTaxProvider.isFeeTaxable(new FulfillmentGroupFeeImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link CountryImpl} (default constructor).</li>
   *   <li>When {@link AddressImpl} (default constructor) Country is
   * {@link CountryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenCountryImpl_whenAddressImplCountryIsCountryImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setCountry(new CountryImpl());
    address.setStateProvinceRegion(null);
    address.setState(null);
    address.setCity(null);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenEmptyString() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setStateProvinceRegion("");

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 0.5}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenHashMap42Is05_thenReturnBigDecimalWith05() {
    // Arrange
    HashMap<String, Double> itemCountryTaxRateMap = new HashMap<>();
    itemCountryTaxRateMap.put("42", 0.5d);

    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(itemCountryTaxRateMap);
    ISOCountry isoCountryAlpha2 = mock(ISOCountry.class);
    when(isoCountryAlpha2.getName()).thenReturn("42");
    when(isoCountryAlpha2.getAlpha2()).thenReturn("Alpha2");

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(isoCountryAlpha2);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    verify(isoCountryAlpha2, atLeast(1)).getAlpha2();
    verify(isoCountryAlpha2, atLeast(1)).getName();
    assertEquals(new BigDecimal("0.5"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link ISOCountry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenISOCountry() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(mock(ISOCountry.class));

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link ISOCountry} {@link ISOCountry#getAlpha2()} return
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenISOCountryGetAlpha2Return42() {
    // Arrange
    HashMap<String, Double> itemCountryTaxRateMap = new HashMap<>();
    itemCountryTaxRateMap.put("42", 0.5d);

    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(itemCountryTaxRateMap);
    ISOCountry isoCountryAlpha2 = mock(ISOCountry.class);
    when(isoCountryAlpha2.getAlpha2()).thenReturn("42");

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(isoCountryAlpha2);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    verify(isoCountryAlpha2, atLeast(1)).getAlpha2();
    assertEquals(new BigDecimal("0.5"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link ISOCountry} {@link ISOCountry#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link ISOCountry#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenISOCountryGetNameReturnName_thenCallsGetName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    ISOCountry isoCountryAlpha2 = mock(ISOCountry.class);
    when(isoCountryAlpha2.getName()).thenReturn("Name");
    when(isoCountryAlpha2.getAlpha2()).thenReturn("Alpha2");

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(isoCountryAlpha2);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    verify(isoCountryAlpha2, atLeast(1)).getAlpha2();
    verify(isoCountryAlpha2, atLeast(1)).getName();
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link ISOCountry} {@link ISOCountry#getName()} return
   * {@code null}.</li>
   *   <li>Then calls {@link ISOCountry#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenISOCountryGetNameReturnNull_thenCallsGetName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    ISOCountry isoCountryAlpha2 = mock(ISOCountry.class);
    when(isoCountryAlpha2.getName()).thenReturn(null);
    when(isoCountryAlpha2.getAlpha2()).thenReturn("Alpha2");

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(isoCountryAlpha2);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    verify(isoCountryAlpha2, atLeast(1)).getAlpha2();
    verify(isoCountryAlpha2).getName();
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenISOCountryImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(new ISOCountryImpl());

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenISOCountryImpl2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(new ISOCountryImpl());

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} (default constructor).</li>
   *   <li>When {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenSimpleTaxProvider_whenAddressImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(new AddressImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link StateImpl} (default constructor) Name is
   * {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenStateImplNameIs42MainSt() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(null);

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setCountry(null);
    address.setStateProvinceRegion(null);
    address.setState(state);
    address.setCity(null);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link StateImpl} (default constructor) Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenStateImplNameIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(null);

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setCountry(null);
    address.setStateProvinceRegion(null);
    address.setState(state);
    address.setCity(null);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@link StateImpl} (default constructor).</li>
   *   <li>When {@link AddressImpl} (default constructor) State is {@link StateImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenStateImpl_whenAddressImplStateIsStateImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setCountry(null);
    address.setStateProvinceRegion(null);
    address.setState(new StateImpl());
    address.setCity(null);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link AddressImpl} (default constructor) City is
   * {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenTrue_whenAddressImplCityIs42MainSt() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setCountry(null);
    address.setStateProvinceRegion(null);
    address.setState(null);
    address.setCity("42 Main St");

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link AddressImpl} (default constructor) StateProvinceRegion is
   * {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenTrue_whenAddressImplStateProvinceRegionIs42MainSt() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setCountry(null);
    address.setStateProvinceRegion("42 Main St");
    address.setState(null);
    address.setCity(null);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Given {@code us-east-2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_givenUsEast2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setStateProvinceRegion("us-east-2");

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_thenReturnBigDecimalWith100() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(new AddressImpl());

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_whenAddressImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(null);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(new AddressImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate_whenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(null);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(null);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setState(null);
    address.setCountry(null);
    address.setStateProvinceRegion("Fulfillment Group");
    address.setCity(null);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(null);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(null);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(null);
    fulfillmentGroup.setAddress(new AddressImpl());

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is
   * {@code Fulfillment Group}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImplCityIsFulfillmentGroup() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setState(null);
    address.setCountry(null);
    address.setStateProvinceRegion(null);
    address.setCity("Fulfillment Group");

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(null);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Country is
   * {@link CountryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImplCountryIsCountryImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setState(null);
    address.setCountry(new CountryImpl());
    address.setStateProvinceRegion(null);
    address.setCity(null);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(null);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) State is
   * {@link StateImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImplStateIsStateImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(null);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setState(new StateImpl());
    address.setCountry(null);
    address.setStateProvinceRegion(null);
    address.setCity(null);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(null);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link CountryImpl} (default constructor) Name is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup_givenCountryImplNameIsName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(null);

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation("Fulfillment Group");

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setPostalCode(null);
    address.setState(null);
    address.setCountry(country);
    address.setStateProvinceRegion(null);
    address.setCity(null);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(null);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>When {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup_whenFulfillmentGroupImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(new FulfillmentGroupImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>When {@link FulfillmentGroupImpl} (default constructor) Address is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup_whenFulfillmentGroupImplAddressIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(null);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(null);
    fulfillmentGroup.setAddress(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleTaxProvider}
   *   <li>{@link SimpleTaxProvider#setDefaultFulfillmentGroupTaxRate(Double)}
   *   <li>{@link SimpleTaxProvider#setDefaultItemTaxRate(Double)}
   *   <li>{@link SimpleTaxProvider#setFulfillmentGroupCityTaxRateMap(Map)}
   *   <li>{@link SimpleTaxProvider#setFulfillmentGroupCountryTaxRateMap(Map)}
   *   <li>{@link SimpleTaxProvider#setFulfillmentGroupPostalCodeTaxRateMap(Map)}
   *   <li>{@link SimpleTaxProvider#setFulfillmentGroupStateTaxRateMap(Map)}
   *   <li>{@link SimpleTaxProvider#setItemCityTaxRateMap(Map)}
   *   <li>{@link SimpleTaxProvider#setItemCountryTaxRateMap(Map)}
   *   <li>{@link SimpleTaxProvider#setItemPostalCodeTaxRateMap(Map)}
   *   <li>{@link SimpleTaxProvider#setItemStateTaxRateMap(Map)}
   *   <li>{@link SimpleTaxProvider#cancelTax(Order, ModuleConfiguration)}
   *   <li>{@link SimpleTaxProvider#getDefaultFulfillmentGroupTaxRate()}
   *   <li>{@link SimpleTaxProvider#getDefaultItemTaxRate()}
   *   <li>{@link SimpleTaxProvider#getFulfillmentGroupCityTaxRateMap()}
   *   <li>{@link SimpleTaxProvider#getFulfillmentGroupCountryTaxRateMap()}
   *   <li>{@link SimpleTaxProvider#getFulfillmentGroupPostalCodeTaxRateMap()}
   *   <li>{@link SimpleTaxProvider#getFulfillmentGroupStateTaxRateMap()}
   *   <li>{@link SimpleTaxProvider#getItemCityTaxRateMap()}
   *   <li>{@link SimpleTaxProvider#getItemCountryTaxRateMap()}
   *   <li>{@link SimpleTaxProvider#getItemPostalCodeTaxRateMap()}
   *   <li>{@link SimpleTaxProvider#getItemStateTaxRateMap()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws TaxException {
    // Arrange and Act
    SimpleTaxProvider actualSimpleTaxProvider = new SimpleTaxProvider();
    actualSimpleTaxProvider.setDefaultFulfillmentGroupTaxRate(10.0d);
    actualSimpleTaxProvider.setDefaultItemTaxRate(10.0d);
    HashMap<String, Double> fulfillmentGroupCityTaxRateMap = new HashMap<>();
    actualSimpleTaxProvider.setFulfillmentGroupCityTaxRateMap(fulfillmentGroupCityTaxRateMap);
    HashMap<String, Double> fulfillmentGroupCountryTaxRateMap = new HashMap<>();
    actualSimpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(fulfillmentGroupCountryTaxRateMap);
    HashMap<String, Double> fulfillmentGroupPostalCodeTaxRateMap = new HashMap<>();
    actualSimpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(fulfillmentGroupPostalCodeTaxRateMap);
    HashMap<String, Double> fulfillmentGroupStateTaxRateMap = new HashMap<>();
    actualSimpleTaxProvider.setFulfillmentGroupStateTaxRateMap(fulfillmentGroupStateTaxRateMap);
    HashMap<String, Double> itemCityTaxRateMap = new HashMap<>();
    actualSimpleTaxProvider.setItemCityTaxRateMap(itemCityTaxRateMap);
    HashMap<String, Double> itemCountryTaxRateMap = new HashMap<>();
    actualSimpleTaxProvider.setItemCountryTaxRateMap(itemCountryTaxRateMap);
    HashMap<String, Double> itemPostalCodeTaxRateMap = new HashMap<>();
    actualSimpleTaxProvider.setItemPostalCodeTaxRateMap(itemPostalCodeTaxRateMap);
    HashMap<String, Double> itemStateTaxRateMap = new HashMap<>();
    actualSimpleTaxProvider.setItemStateTaxRateMap(itemStateTaxRateMap);
    NullOrderImpl order = new NullOrderImpl();
    actualSimpleTaxProvider.cancelTax(order, new SiteMapConfigurationImpl());
    Double actualDefaultFulfillmentGroupTaxRate = actualSimpleTaxProvider.getDefaultFulfillmentGroupTaxRate();
    Double actualDefaultItemTaxRate = actualSimpleTaxProvider.getDefaultItemTaxRate();
    Map<String, Double> actualFulfillmentGroupCityTaxRateMap = actualSimpleTaxProvider
        .getFulfillmentGroupCityTaxRateMap();
    Map<String, Double> actualFulfillmentGroupCountryTaxRateMap = actualSimpleTaxProvider
        .getFulfillmentGroupCountryTaxRateMap();
    Map<String, Double> actualFulfillmentGroupPostalCodeTaxRateMap = actualSimpleTaxProvider
        .getFulfillmentGroupPostalCodeTaxRateMap();
    Map<String, Double> actualFulfillmentGroupStateTaxRateMap = actualSimpleTaxProvider
        .getFulfillmentGroupStateTaxRateMap();
    Map<String, Double> actualItemCityTaxRateMap = actualSimpleTaxProvider.getItemCityTaxRateMap();
    Map<String, Double> actualItemCountryTaxRateMap = actualSimpleTaxProvider.getItemCountryTaxRateMap();
    Map<String, Double> actualItemPostalCodeTaxRateMap = actualSimpleTaxProvider.getItemPostalCodeTaxRateMap();
    Map<String, Double> actualItemStateTaxRateMap = actualSimpleTaxProvider.getItemStateTaxRateMap();

    // Assert that nothing has changed
    assertEquals(10.0d, actualDefaultFulfillmentGroupTaxRate.doubleValue(), 0.0);
    assertEquals(10.0d, actualDefaultItemTaxRate.doubleValue(), 0.0);
    assertTrue(actualFulfillmentGroupCityTaxRateMap.isEmpty());
    assertTrue(actualFulfillmentGroupCountryTaxRateMap.isEmpty());
    assertTrue(actualFulfillmentGroupPostalCodeTaxRateMap.isEmpty());
    assertTrue(actualFulfillmentGroupStateTaxRateMap.isEmpty());
    assertTrue(actualItemCityTaxRateMap.isEmpty());
    assertTrue(actualItemCountryTaxRateMap.isEmpty());
    assertTrue(actualItemPostalCodeTaxRateMap.isEmpty());
    assertTrue(actualItemStateTaxRateMap.isEmpty());
    assertSame(fulfillmentGroupCityTaxRateMap, actualFulfillmentGroupCityTaxRateMap);
    assertSame(fulfillmentGroupCountryTaxRateMap, actualFulfillmentGroupCountryTaxRateMap);
    assertSame(fulfillmentGroupPostalCodeTaxRateMap, actualFulfillmentGroupPostalCodeTaxRateMap);
    assertSame(fulfillmentGroupStateTaxRateMap, actualFulfillmentGroupStateTaxRateMap);
    assertSame(itemCityTaxRateMap, actualItemCityTaxRateMap);
    assertSame(itemCountryTaxRateMap, actualItemCountryTaxRateMap);
    assertSame(itemPostalCodeTaxRateMap, actualItemPostalCodeTaxRateMap);
    assertSame(itemStateTaxRateMap, actualItemStateTaxRateMap);
  }
}
