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
   * Method under test: {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}
   */
  @Test
  public void testCanRespond() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertFalse(simpleTaxProvider.canRespond(new SiteMapConfigurationImpl()));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}
   */
  @Test
  public void testCanRespond2() {
    // Arrange, Act and Assert
    assertTrue((new SimpleTaxProvider()).canRespond(null));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}
   */
  @Test
  public void testCanRespond3() {
    // Arrange, Act and Assert
    assertFalse((new SimpleTaxProvider()).canRespond(mock(ModuleConfiguration.class)));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#calculateTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  public void testCalculateTaxForOrder() throws TaxException {
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
   * Method under test:
   * {@link SimpleTaxProvider#calculateTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  public void testCalculateTaxForOrder2() throws TaxException {
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

    // Act and Assert
    assertSame(order, simpleTaxProvider.calculateTaxForOrder(order, new SiteMapConfigurationImpl()));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes3() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes4() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes5() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes6() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes7() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes8() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes9() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes10() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes11() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes12() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes13() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes14() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes15() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupItemTaxes16() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes2() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes3() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes4() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes5() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes6() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes7() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes8() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes9() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes10() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes11() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes12() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes13() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes14() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes15() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes16() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupFeeTaxes17() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupTaxes() {
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
   * Method under test:
   * {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}
   */
  @Test
  public void testHandleFulfillmentGroupTaxes2() {
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
   * Method under test:
   * {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  public void testApplyTaxFactor() {
    // Arrange
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl();
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
    assertEquals(1, taxes.size());
    assertEquals(taxMultiplier, taxMultiplier.abs());
    assertEquals(taxMultiplier, taxMultiplier.zero());
    assertSame(taxDetailImpl, taxes.get(0));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  public void testApplyTaxFactor2() {
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
    assertEquals(expectedAmount, taxMultiplier.getAmount());
    assertEquals(taxMultiplier, taxMultiplier.abs());
    assertEquals(taxMultiplier, taxMultiplier.zero());
  }

  /**
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.findExistingTaxDetail(new ArrayList<>()));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail2() {
    // Arrange
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    Money amount = new Money();
    taxes.add(new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3")));

    // Act and Assert
    assertNull(simpleTaxProvider.findExistingTaxDetail(taxes));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail3() {
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
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail4() {
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
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail5() {
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
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail6() {
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
   * Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  public void testFindExistingTaxDetail7() {
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
   * Method under test:
   * {@link SimpleTaxProvider#commitTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  public void testCommitTaxForOrder() throws TaxException {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, simpleTaxProvider.commitTaxForOrder(order, new SiteMapConfigurationImpl()));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#commitTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  public void testCommitTaxForOrder2() throws TaxException {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, simpleTaxProvider.commitTaxForOrder(order, mock(ModuleConfiguration.class)));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}
   */
  @Test
  public void testLookupPostalCodeRate() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupPostalCodeRate(new HashMap<>(), "Postal Code"));
    assertNull(simpleTaxProvider.lookupPostalCodeRate(new HashMap<>(), null));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}
   */
  @Test
  public void testLookupPostalCodeRate2() {
    // Arrange
    HashMap<String, Double> postalCodeTaxRateMap = new HashMap<>();
    postalCodeTaxRateMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleTaxProvider.lookupPostalCodeRate(postalCodeTaxRateMap, "Postal Code"));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupCityRate(Map, String)}
   */
  @Test
  public void testLookupCityRate() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupCityRate(new HashMap<>(), "Oxford"));
    assertNull(simpleTaxProvider.lookupCityRate(new HashMap<>(), null));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupCityRate(Map, String)}
   */
  @Test
  public void testLookupCityRate2() {
    // Arrange
    HashMap<String, Double> cityTaxRateMap = new HashMap<>();
    cityTaxRateMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCityRate(cityTaxRateMap, "Oxford"));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRate() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> stateTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(stateTaxRateMap, new StateImpl()));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRate2() {
    // Arrange, Act and Assert
    assertNull((new SimpleTaxProvider()).lookupStateRate(null, (State) null));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRate3() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), (State) null));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRate4() {
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
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRate5() {
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
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRate6() {
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
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  public void testLookupStateRate7() {
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
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  public void testLookupStateRate8() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), "us-east-2"));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  public void testLookupStateRate9() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), (String) null));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  public void testLookupStateRate10() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), ""));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  public void testLookupStateRate11() {
    // Arrange
    HashMap<String, Double> stateTaxRateMap = new HashMap<>();
    stateTaxRateMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(stateTaxRateMap, "us-east-2"));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRate() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, new ISOCountryImpl()));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRate2() {
    // Arrange, Act and Assert
    assertNull((new SimpleTaxProvider()).lookupCountryRate(null, (ISOCountry) null));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRate3() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(new HashMap<>(), (ISOCountry) null));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRate4() {
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
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRate5() {
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
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRate6() {
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
   * Method under test:
   * {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  public void testLookupCountryRate7() {
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
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRate8() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, new CountryImpl()));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRate9() {
    // Arrange, Act and Assert
    assertNull((new SimpleTaxProvider()).lookupCountryRate(null, (Country) null));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRate10() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(new HashMap<>(), (Country) null));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRate11() {
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
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRate12() {
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
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRate13() {
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
   * Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  public void testLookupCountryRate14() {
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
   * Method under test:
   * {@link SimpleTaxProvider#isItemTaxable(FulfillmentGroupItem)}
   */
  @Test
  public void testIsItemTaxable() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    FulfillmentGroupItemImpl item = new FulfillmentGroupItemImpl();
    item.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertTrue(simpleTaxProvider.isItemTaxable(item));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#isFeeTaxable(FulfillmentGroupFee)}
   */
  @Test
  public void testIsFeeTaxable() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertFalse(simpleTaxProvider.isFeeTaxable(new FulfillmentGroupFeeImpl()));
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#isFeeTaxable(FulfillmentGroupFee)}
   */
  @Test
  public void testIsFeeTaxable2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    FulfillmentGroupFeeImpl fee = new FulfillmentGroupFeeImpl();
    fee.setTaxable(true);

    // Act and Assert
    assertTrue(simpleTaxProvider.isFeeTaxable(fee));
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(new AddressImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate2() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate3() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate4() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate5() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate6() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate7() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate8() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate9() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate10() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(new AddressImpl());

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate11() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setStateProvinceRegion("us-east-2");

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate12() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(new ISOCountryImpl());

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate13() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setStateProvinceRegion("");

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate14() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(mock(ISOCountry.class));

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate15() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(new ISOCountryImpl());

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate16() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate17() {
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
    assertSame(actualDetermineItemTaxRateResult.ZERO, actualDetermineItemTaxRateResult);
  }

  /**
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate18() {
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
   * Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  public void testDetermineItemTaxRate19() {
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
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult = simpleTaxProvider
        .determineTaxRateForFulfillmentGroup(new FulfillmentGroupImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
    assertSame(actualDetermineTaxRateForFulfillmentGroupResult.ZERO, actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup2() {
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
    assertSame(actualDetermineTaxRateForFulfillmentGroupResult.ZERO, actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup3() {
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
    assertSame(actualDetermineTaxRateForFulfillmentGroupResult.ZERO, actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup4() {
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
    assertSame(actualDetermineTaxRateForFulfillmentGroupResult.ZERO, actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup5() {
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
    assertSame(actualDetermineTaxRateForFulfillmentGroupResult.ZERO, actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup6() {
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
    assertSame(actualDetermineTaxRateForFulfillmentGroupResult.ZERO, actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup7() {
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
    assertSame(actualDetermineTaxRateForFulfillmentGroupResult.ZERO, actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Method under test:
   * {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testDetermineTaxRateForFulfillmentGroup8() {
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
    assertSame(actualDetermineTaxRateForFulfillmentGroupResult.ZERO, actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
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
