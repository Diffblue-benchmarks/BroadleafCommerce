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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.domain.TaxDetail;
import org.broadleafcommerce.core.order.domain.TaxDetailImpl;
import org.broadleafcommerce.core.order.domain.TaxType;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.TaxException;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

  @Autowired private SimpleTaxProvider simpleTaxProvider;

  /**
   * Test {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTaxProvider.canRespond(ModuleConfiguration)"})
  public void testCanRespond_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SimpleTaxProvider().canRespond(null));
  }

  /**
   * Test {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}.
   *
   * <ul>
   *   <li>When {@link SiteMapConfigurationImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#canRespond(ModuleConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTaxProvider.canRespond(ModuleConfiguration)"})
  public void testCanRespond_whenSiteMapConfigurationImpl_thenReturnFalse() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertFalse(simpleTaxProvider.canRespond(new SiteMapConfigurationImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#calculateTaxForOrder(Order, ModuleConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#isTaxExempt()} return {@code true}.
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#calculateTaxForOrder(Order,
   * ModuleConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order SimpleTaxProvider.calculateTaxForOrder(Order, ModuleConfiguration)"})
  public void testCalculateTaxForOrder_givenCustomerIsTaxExemptReturnTrue_thenReturnOrderImpl()
      throws TaxException {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(10.0d);
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Customer customer = mock(Customer.class);
    when(customer.isTaxExempt()).thenReturn(true);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(1L);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTotalTax(new Money());
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());

    ArrayList<FulfillmentGroupFee> fulfillmentGroupFees = new ArrayList<>();
    fulfillmentGroupFees.add(fulfillmentGroupFeeImpl);

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
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
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(new ISOCountryImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);
    fulfillmentGroupImpl.setFulfillmentGroupFees(fulfillmentGroupFees);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setAddress(address);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(customer);
    order.setEmailAddress("42 Main St");
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    Order actualCalculateTaxForOrderResult =
        simpleTaxProvider.calculateTaxForOrder(order, new SiteMapConfigurationImpl());

    // Assert
    verify(customer).isTaxExempt();
    assertSame(order, actualCalculateTaxForOrderResult);
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(null);
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes3() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes4() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes5() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) StateProvinceRegion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes_givenAddressImplStateProvinceRegionIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion(null);
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) StateProvinceRegion is {@code us-east-2}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes_givenAddressImplStateProvinceRegionIsUsEast2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("us-east-2");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then calls {@link BundleOrderItemImpl#getOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes_givenBigDecimalWith23_thenCallsGetOrder() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    Money amount = new Money();
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3"));
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#isTaxable()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes_givenBundleOrderItemImplIsTaxableReturnFalse() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.isTaxable()).thenReturn(false);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(mock(TaxDetailImpl.class));

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link
   *       TaxType#COMBINED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes_givenTaxDetailImplGetTypeReturnCombined() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.COMBINED);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link
   *       TaxType#TaxType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes_givenTaxDetailImplGetTypeReturnTaxType() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(new TaxType());

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link TaxType}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes_givenTaxDetailImplGetTypeReturnTaxType2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(mock(TaxType.class));

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupItemTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupItemTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupItemTaxes_thenCallsGetOrder() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    when(orderItem.isTaxable()).thenReturn(true);

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(1L);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTaxes(taxes);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(fulfillmentGroupItemImpl);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation(null);

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setActive(true);
    addressImpl.setAddressLine1("42 Main St");
    addressImpl.setAddressLine2("42 Main St");
    addressImpl.setAddressLine3("42 Main St");
    addressImpl.setBusiness(true);
    addressImpl.setCompanyName("Company Name");
    addressImpl.setCounty("3");
    addressImpl.setDefault(true);
    addressImpl.setEmailAddress("42 Main St");
    addressImpl.setFax("Fax");
    addressImpl.setFirstName("Jane");
    addressImpl.setFullName("Dr Jane Doe");
    addressImpl.setId(1L);
    addressImpl.setIsoCountrySubdivision("GB");
    addressImpl.setLastName("Doe");
    addressImpl.setMailing(true);
    addressImpl.setPhoneFax(new PhoneImpl());
    addressImpl.setPhonePrimary(new PhoneImpl());
    addressImpl.setPhoneSecondary(new PhoneImpl());
    addressImpl.setPrimaryPhone("6625550144");
    addressImpl.setSecondaryPhone("6625550144");
    addressImpl.setStandardized(true);
    addressImpl.setStreet(true);
    addressImpl.setTokenizedAddress("42 Main St");
    addressImpl.setVerificationLevel("Verification Level");
    addressImpl.setZipFour("21654");
    addressImpl.setStateProvinceRegion("");
    addressImpl.setIsoCountryAlpha2(isoCountryAlpha2);
    addressImpl.setPostalCode("42 Main St");
    addressImpl.setCity("42 Main St");
    addressImpl.setState(state);
    addressImpl.setCountry(country);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getAddress()).thenReturn(addressImpl);
    when(fulfillmentGroup.getFulfillmentGroupItems()).thenReturn(fulfillmentGroupItemList);

    // Act
    simpleTaxProvider.handleFulfillmentGroupItemTaxes(fulfillmentGroup);

    // Assert
    verify(orderItem).isTaxable();
    verify(fulfillmentGroup).getAddress();
    verify(fulfillmentGroup).getFulfillmentGroupItems();
    verify(orderItem).getOrder();
    verify(taxDetailImpl).getType();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupFeeTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupFeeTaxes_givenStateGetNameReturnName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());

    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFee.setTaxable(true);

    State state = mock(State.class);
    when(state.getName()).thenReturn("Name");
    when(state.getAbbreviation()).thenReturn("Abbreviation");

    AddressImpl address = new AddressImpl();
    address.setState(state);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state, atLeast(1)).getName();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#handleFulfillmentGroupFeeTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupFeeTaxes(FulfillmentGroup)"})
  public void testHandleFulfillmentGroupFeeTaxes_givenStateGetNameReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());

    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFee.setTaxable(true);

    State state = mock(State.class);
    when(state.getName()).thenReturn(null);
    when(state.getAbbreviation()).thenReturn("Abbreviation");

    AddressImpl address = new AddressImpl();
    address.setState(state);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Act
    simpleTaxProvider.handleFulfillmentGroupFeeTaxes(fulfillmentGroup);

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state).getName();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupTaxes(FulfillmentGroup)"})
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

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state, atLeast(1)).getName();
  }

  /**
   * Test {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#handleFulfillmentGroupTaxes(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.handleFulfillmentGroupTaxes(FulfillmentGroup)"})
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

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state).getName();
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Given Bean Name{blEntityConfiguration}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_givenBeanNameBlEntityConfiguration_thenArrayListEmpty() {
    // Arrange
    ArrayList<TaxDetail> taxes = new ArrayList<>();

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, null, mock(Money.class));

    // Assert that nothing has changed
    assertTrue(taxes.isEmpty());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   *   <li>Then {@link ArrayList#ArrayList()} first Amount is {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_givenMoney_thenArrayListFirstAmountIsZero() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(TaxDetail.class)))
        .thenReturn(new TaxDetailImpl());
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    BigDecimal taxFactor = new BigDecimal("2.3");

    Money taxMultiplier = mock(Money.class);
    when(taxMultiplier.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(taxMultiplier).multiply(isA(BigDecimal.class));
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.order.domain.TaxDetail"), isA(Class.class));
    assertEquals(1, taxes.size());
    TaxDetail getResult = taxes.get(0);
    assertTrue(getResult instanceof TaxDetailImpl);
    assertEquals(Money.ZERO, getResult.getAmount());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Given {@link Money}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_givenMoney_whenArrayList_thenArrayListSizeIsOne() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    doNothing().when(taxDetailImpl).setAmount(Mockito.<Money>any());
    doNothing().when(taxDetailImpl).setRate(Mockito.<BigDecimal>any());
    doNothing().when(taxDetailImpl).setType(Mockito.<TaxType>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(TaxDetail.class)))
        .thenReturn(taxDetailImpl);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    BigDecimal taxFactor = new BigDecimal("2.3");

    Money taxMultiplier = mock(Money.class);
    when(taxMultiplier.multiply(Mockito.<BigDecimal>any())).thenReturn(mock(Money.class));

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(taxMultiplier).multiply(isA(BigDecimal.class));
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.order.domain.TaxDetail"), isA(Class.class));
    verify(taxDetailImpl).setAmount(isA(Money.class));
    verify(taxDetailImpl).setRate(isA(BigDecimal.class));
    verify(taxDetailImpl).setType(isA(TaxType.class));
    assertEquals(1, taxes.size());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} (default constructor).
   *   <li>When {@link Money}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_givenSimpleTaxProvider_whenMoney_thenArrayListEmpty() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    when(taxDetailImpl.getType()).thenReturn(TaxType.COMBINED);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, null, mock(Money.class));

    // Assert
    verify(taxDetailImpl).getType();
    assertTrue(taxes.isEmpty());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link TaxType#CITY}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_givenTaxDetailImplGetTypeReturnCity_thenArrayListSizeIsTwo() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    doNothing().when(taxDetailImpl).setAmount(Mockito.<Money>any());
    doNothing().when(taxDetailImpl).setRate(Mockito.<BigDecimal>any());
    doNothing().when(taxDetailImpl).setType(Mockito.<TaxType>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(TaxDetail.class)))
        .thenReturn(taxDetailImpl);

    TaxDetailImpl taxDetailImpl2 = mock(TaxDetailImpl.class);
    when(taxDetailImpl2.getType()).thenReturn(TaxType.CITY);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl2);
    BigDecimal taxFactor = new BigDecimal("2.3");

    Money taxMultiplier = mock(Money.class);
    when(taxMultiplier.multiply(Mockito.<BigDecimal>any())).thenReturn(mock(Money.class));

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(taxMultiplier).multiply(isA(BigDecimal.class));
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.order.domain.TaxDetail"), isA(Class.class));
    verify(taxDetailImpl2).getType();
    verify(taxDetailImpl).setAmount(isA(Money.class));
    verify(taxDetailImpl).setRate(isA(BigDecimal.class));
    verify(taxDetailImpl).setType(isA(TaxType.class));
    assertEquals(2, taxes.size());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link
   *       TaxType#TaxType()}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_givenTaxDetailImplGetTypeReturnTaxType_thenArrayListSizeIsTwo() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    doNothing().when(taxDetailImpl).setAmount(Mockito.<Money>any());
    doNothing().when(taxDetailImpl).setRate(Mockito.<BigDecimal>any());
    doNothing().when(taxDetailImpl).setType(Mockito.<TaxType>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(TaxDetail.class)))
        .thenReturn(taxDetailImpl);

    TaxDetailImpl taxDetailImpl2 = mock(TaxDetailImpl.class);
    when(taxDetailImpl2.getType()).thenReturn(new TaxType());

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl2);
    BigDecimal taxFactor = new BigDecimal("2.3");

    Money taxMultiplier = mock(Money.class);
    when(taxMultiplier.multiply(Mockito.<BigDecimal>any())).thenReturn(mock(Money.class));

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(taxMultiplier).multiply(isA(BigDecimal.class));
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.order.domain.TaxDetail"), isA(Class.class));
    verify(taxDetailImpl2).getType();
    verify(taxDetailImpl).setAmount(isA(Money.class));
    verify(taxDetailImpl).setRate(isA(BigDecimal.class));
    verify(taxDetailImpl).setType(isA(TaxType.class));
    assertEquals(2, taxes.size());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link TaxType}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_givenTaxDetailImplGetTypeReturnTaxType_thenArrayListSizeIsTwo2() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    doNothing().when(taxDetailImpl).setAmount(Mockito.<Money>any());
    doNothing().when(taxDetailImpl).setRate(Mockito.<BigDecimal>any());
    doNothing().when(taxDetailImpl).setType(Mockito.<TaxType>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(TaxDetail.class)))
        .thenReturn(taxDetailImpl);

    TaxDetailImpl taxDetailImpl2 = mock(TaxDetailImpl.class);
    when(taxDetailImpl2.getType()).thenReturn(mock(TaxType.class));

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl2);
    BigDecimal taxFactor = new BigDecimal("2.3");

    Money taxMultiplier = mock(Money.class);
    when(taxMultiplier.multiply(Mockito.<BigDecimal>any())).thenReturn(mock(Money.class));

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(taxMultiplier).multiply(isA(BigDecimal.class));
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.order.domain.TaxDetail"), isA(Class.class));
    verify(taxDetailImpl2).getType();
    verify(taxDetailImpl).setAmount(isA(Money.class));
    verify(taxDetailImpl).setRate(isA(BigDecimal.class));
    verify(taxDetailImpl).setType(isA(TaxType.class));
    assertEquals(2, taxes.size());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Amount abs abs is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_thenArrayListFirstAmountAbsAbsIsMoney() {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    doNothing().when(taxDetailImpl).setAmount(Mockito.<Money>any());
    doNothing().when(taxDetailImpl).setRate(Mockito.<BigDecimal>any());
    doNothing().when(taxDetailImpl).setType(Mockito.<TaxType>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(TaxDetail.class)))
        .thenReturn(taxDetailImpl);

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    Money amount = new Money();
    TaxDetailImpl taxDetailImpl2 = new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3"));
    taxes.add(taxDetailImpl2);
    BigDecimal taxFactor = new BigDecimal("2.3");

    Money taxMultiplier = mock(Money.class);
    when(taxMultiplier.multiply(Mockito.<BigDecimal>any())).thenReturn(mock(Money.class));

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(taxMultiplier).multiply(isA(BigDecimal.class));
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.order.domain.TaxDetail"), isA(Class.class));
    verify(taxDetailImpl).setAmount(isA(Money.class));
    verify(taxDetailImpl).setRate(isA(BigDecimal.class));
    verify(taxDetailImpl).setType(isA(TaxType.class));
    assertEquals(2, taxes.size());
    TaxDetail getResult = taxes.get(0);
    assertTrue(getResult instanceof TaxDetailImpl);
    assertEquals(amount, getResult.getAmount().abs().abs());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Amount abs zero is {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_thenArrayListFirstAmountAbsZeroIsZero() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(TaxDetail.class)))
        .thenReturn(new TaxDetailImpl());
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    BigDecimal taxFactor = new BigDecimal("2.3");

    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    Money taxMultiplier = mock(Money.class);
    when(taxMultiplier.multiply(Mockito.<BigDecimal>any())).thenReturn(money);

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(money).getAmount();
    verify(taxMultiplier).multiply(isA(BigDecimal.class));
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.order.domain.TaxDetail"), isA(Class.class));
    assertEquals(1, taxes.size());
    TaxDetail getResult = taxes.get(0);
    assertTrue(getResult instanceof TaxDetailImpl);
    Money money2 = Money.ZERO;
    Money amount = getResult.getAmount();
    assertEquals(money2, amount.abs().zero());
    assertEquals(money2, amount.zero());
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Amount zero Amount is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_thenArrayListFirstAmountZeroAmountIsBigDecimalWith000() {
    // Arrange
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    Money amount = new Money();
    TaxDetailImpl taxDetailImpl =
        new TaxDetailImpl(TaxType.COMBINED, amount, new BigDecimal("2.3"));
    taxes.add(taxDetailImpl);
    BigDecimal taxFactor = new BigDecimal("2.3");

    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    Money taxMultiplier = mock(Money.class);
    when(taxMultiplier.multiply(Mockito.<BigDecimal>any())).thenReturn(money);

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(money).getAmount();
    verify(taxMultiplier).multiply(isA(BigDecimal.class));
    assertEquals(1, taxes.size());
    TaxDetail getResult = taxes.get(0);
    assertTrue(getResult instanceof TaxDetailImpl);
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money amount2 = getResult.getAmount();
    Money zeroResult = amount2.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("2.30"), amount2.getAmount());
    Money actualAbsResult = amount2.abs();
    assertEquals(amount2, actualAbsResult);
    BigDecimal amount3 = zeroResult.zero().getAmount();
    assertSame(amount3, zeroResult.abs().getAmount());
    assertSame(amount3, amount3);
  }

  /**
   * Test {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link ArrayList#ArrayList()} first Amount is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#applyTaxFactor(List, BigDecimal, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTaxProvider.applyTaxFactor(List, BigDecimal, Money)"})
  public void testApplyTaxFactor_whenMoney_thenArrayListFirstAmountIsMoney() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(TaxDetail.class)))
        .thenReturn(new TaxDetailImpl());
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    BigDecimal taxFactor = new BigDecimal("2.3");
    Money taxMultiplier = new Money();

    // Act
    simpleTaxProvider.applyTaxFactor(taxes, taxFactor, taxMultiplier);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.core.order.domain.TaxDetail"), isA(Class.class));
    assertEquals(1, taxes.size());
    TaxDetail getResult = taxes.get(0);
    assertTrue(getResult instanceof TaxDetailImpl);
    assertEquals(taxMultiplier, getResult.getAmount());
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   *
   * <p>Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxDetail SimpleTaxProvider.findExistingTaxDetail(List)"})
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
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxDetail SimpleTaxProvider.findExistingTaxDetail(List)"})
  public void testFindExistingTaxDetail_givenBigDecimalWith23() {
    // Arrange
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    Money amount = new Money();
    TaxDetailImpl taxDetailImpl = new TaxDetailImpl(TaxType.CITY, amount, new BigDecimal("2.3"));
    taxes.add(taxDetailImpl);

    // Act and Assert
    assertNull(simpleTaxProvider.findExistingTaxDetail(taxes));
  }

  /**
   * Test {@link SimpleTaxProvider#findExistingTaxDetail(List)}.
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link TaxType#CITY}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxDetail SimpleTaxProvider.findExistingTaxDetail(List)"})
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
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link
   *       TaxType#COMBINED}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxDetail SimpleTaxProvider.findExistingTaxDetail(List)"})
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
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link
   *       TaxType#TaxType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxDetail SimpleTaxProvider.findExistingTaxDetail(List)"})
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
   *
   * <ul>
   *   <li>Given {@link TaxDetailImpl} {@link TaxDetailImpl#getType()} return {@link TaxType}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxDetail SimpleTaxProvider.findExistingTaxDetail(List)"})
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#findExistingTaxDetail(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxDetail SimpleTaxProvider.findExistingTaxDetail(List)"})
  public void testFindExistingTaxDetail_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.findExistingTaxDetail(new ArrayList<>()));
  }

  /**
   * Test {@link SimpleTaxProvider#commitTaxForOrder(Order, ModuleConfiguration)}.
   *
   * <p>Method under test: {@link SimpleTaxProvider#commitTaxForOrder(Order, ModuleConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order SimpleTaxProvider.commitTaxForOrder(Order, ModuleConfiguration)"})
  public void testCommitTaxForOrder() throws TaxException {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualCommitTaxForOrderResult =
        simpleTaxProvider.commitTaxForOrder(order, new SiteMapConfigurationImpl());

    // Assert
    assertSame(order, actualCommitTaxForOrderResult);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupPostalCodeRate(Map, String)"})
  public void testLookupPostalCodeRate_whenHashMap() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupPostalCodeRate(new HashMap<>(), "Postal Code"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupPostalCodeRate(Map, String)"})
  public void testLookupPostalCodeRate_whenHashMap2() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupPostalCodeRate(new HashMap<>(), null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupPostalCodeRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupPostalCodeRate(Map, String)"})
  public void testLookupPostalCodeRate_whenNull() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupPostalCodeRate(null, "Postal Code"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCityRate(Map, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCityRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCityRate(Map, String)"})
  public void testLookupCityRate_whenHashMap() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupCityRate(new HashMap<>(), "Oxford"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCityRate(Map, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCityRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCityRate(Map, String)"})
  public void testLookupCityRate_whenHashMap2() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupCityRate(new HashMap<>(), null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCityRate(Map, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCityRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCityRate(Map, String)"})
  public void testLookupCityRate_whenNull() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupCityRate(null, "Oxford"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with {@code stateTaxRateMap},
   * {@code stateProvinceRegion}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, String)"})
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), ""));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with {@code stateTaxRateMap},
   * {@code stateProvinceRegion}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, String)"})
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_whenNotBlank() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(null, "not blank"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with {@code stateTaxRateMap},
   * {@code stateProvinceRegion}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, String)"})
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_whenNull() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), (String) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with {@code stateTaxRateMap},
   * {@code stateProvinceRegion}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, String)"})
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_whenSpace() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), " "));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, String)} with {@code stateTaxRateMap},
   * {@code stateProvinceRegion}.
   *
   * <ul>
   *   <li>When {@code us-east-2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, String)"})
  public void testLookupStateRateWithStateTaxRateMapStateProvinceRegion_whenUsEast2() {
    // Arrange, Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), "us-east-2"));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with {@code stateTaxRateMap}, {@code
   * state}.
   *
   * <ul>
   *   <li>Given {@link CountryImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, State)"})
  public void testLookupStateRateWithStateTaxRateMapState_givenCountryImpl_whenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("MD");
    state.setName("MD");

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(null, state));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with {@code stateTaxRateMap}, {@code
   * state}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link StateImpl} (default constructor) Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, State)"})
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
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with {@code stateTaxRateMap}, {@code
   * state}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, State)"})
  public void testLookupStateRateWithStateTaxRateMapState_whenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(new HashMap<>(), (State) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with {@code stateTaxRateMap}, {@code
   * state}.
   *
   * <ul>
   *   <li>When {@link StateImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, State)"})
  public void testLookupStateRateWithStateTaxRateMapState_whenStateImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> stateTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupStateRate(stateTaxRateMap, new StateImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupStateRate(Map, State)} with {@code stateTaxRateMap}, {@code
   * state}.
   *
   * <ul>
   *   <li>When {@link StateImpl} (default constructor) Name is {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupStateRate(Map, State)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupStateRate(Map, State)"})
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
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with {@code countryTaxRateMap},
   * {@code country}.
   *
   * <ul>
   *   <li>Given {@code GB}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, Country)"})
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
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with {@code countryTaxRateMap},
   * {@code country}.
   *
   * <ul>
   *   <li>Given {@code GB}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, Country)"})
  public void testLookupCountryRateWithCountryTaxRateMapCountry_givenGb_whenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation("GB");

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(null, country));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with {@code countryTaxRateMap},
   * {@code country}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, Country)"})
  public void testLookupCountryRateWithCountryTaxRateMapCountry_givenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    Country country = mock(Country.class);
    when(country.getName()).thenReturn(null);
    when(country.getAbbreviation()).thenReturn("Abbreviation");

    // Act
    Double actualLookupCountryRateResult =
        simpleTaxProvider.lookupCountryRate(countryTaxRateMap, country);

    // Assert
    verify(country, atLeast(1)).getAbbreviation();
    verify(country).getName();
    assertNull(actualLookupCountryRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with {@code countryTaxRateMap},
   * {@code country}.
   *
   * <ul>
   *   <li>Then return doubleValue is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, Country)"})
  public void testLookupCountryRateWithCountryTaxRateMapCountry_thenReturnDoubleValueIs05() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    HashMap<String, Double> countryTaxRateMap = new HashMap<>();
    countryTaxRateMap.put("42", 0.5d);

    Country country = mock(Country.class);
    when(country.getAbbreviation()).thenReturn("42");

    // Act
    Double actualLookupCountryRateResult =
        simpleTaxProvider.lookupCountryRate(countryTaxRateMap, country);

    // Assert
    verify(country, atLeast(1)).getAbbreviation();
    assertEquals(0.5d, actualLookupCountryRateResult.doubleValue(), 0.0);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with {@code countryTaxRateMap},
   * {@code country}.
   *
   * <ul>
   *   <li>When {@link Country} {@link Country#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, Country)"})
  public void testLookupCountryRateWithCountryTaxRateMapCountry_whenCountryGetNameReturnName() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    Country country = mock(Country.class);
    when(country.getName()).thenReturn("Name");
    when(country.getAbbreviation()).thenReturn("Abbreviation");

    // Act
    Double actualLookupCountryRateResult =
        simpleTaxProvider.lookupCountryRate(countryTaxRateMap, country);

    // Assert
    verify(country, atLeast(1)).getAbbreviation();
    verify(country, atLeast(1)).getName();
    assertNull(actualLookupCountryRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with {@code countryTaxRateMap},
   * {@code country}.
   *
   * <ul>
   *   <li>When {@link CountryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, Country)"})
  public void testLookupCountryRateWithCountryTaxRateMapCountry_whenCountryImpl_thenReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, new CountryImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, Country)} with {@code countryTaxRateMap},
   * {@code country}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, Country)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, Country)"})
  public void testLookupCountryRateWithCountryTaxRateMapCountry_whenNull_thenReturnNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(new HashMap<>(), (Country) null));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with {@code
   * countryTaxRateMap}, {@code isoCountry}.
   *
   * <ul>
   *   <li>Given {@code Alpha3}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, ISOCountry)"})
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_givenAlpha3_whenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    ISOCountryImpl isoCountry = new ISOCountryImpl();
    isoCountry.setAlpha3("Alpha3");
    isoCountry.setNumericCode(10);
    isoCountry.setStatus(new ISOCodeStatusType());
    isoCountry.setAlpha2("GB");
    isoCountry.setName("GB");

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(null, isoCountry));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with {@code
   * countryTaxRateMap}, {@code isoCountry}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, ISOCountry)"})
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_givenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    ISOCountryImpl isoCountry = new ISOCountryImpl();
    isoCountry.setAlpha3("Alpha3");
    isoCountry.setNumericCode(10);
    isoCountry.setStatus(new ISOCodeStatusType());
    isoCountry.setAlpha2("GB");
    isoCountry.setName(null);

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, isoCountry));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with {@code
   * countryTaxRateMap}, {@code isoCountry}.
   *
   * <ul>
   *   <li>When {@link ISOCountryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, ISOCountry)"})
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_whenISOCountryImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, new ISOCountryImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with {@code
   * countryTaxRateMap}, {@code isoCountry}.
   *
   * <ul>
   *   <li>When {@link ISOCountryImpl} (default constructor) Name is {@code GB}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, ISOCountry)"})
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_whenISOCountryImplNameIsGb() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    HashMap<String, Double> countryTaxRateMap = new HashMap<>();

    ISOCountryImpl isoCountry = new ISOCountryImpl();
    isoCountry.setAlpha3("Alpha3");
    isoCountry.setNumericCode(10);
    isoCountry.setStatus(new ISOCodeStatusType());
    isoCountry.setAlpha2("GB");
    isoCountry.setName("GB");

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(countryTaxRateMap, isoCountry));
  }

  /**
   * Test {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)} with {@code
   * countryTaxRateMap}, {@code isoCountry}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#lookupCountryRate(Map, ISOCountry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Double SimpleTaxProvider.lookupCountryRate(Map, ISOCountry)"})
  public void testLookupCountryRateWithCountryTaxRateMapIsoCountry_whenNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertNull(simpleTaxProvider.lookupCountryRate(new HashMap<>(), (ISOCountry) null));
  }

  /**
   * Test {@link SimpleTaxProvider#isItemTaxable(FulfillmentGroupItem)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#isItemTaxable(FulfillmentGroupItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTaxProvider.isItemTaxable(FulfillmentGroupItem)"})
  public void testIsItemTaxable_givenAuditableCreatedByIsOne_thenReturnFalse() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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
    orderItem.setTaxable(false);
    orderItem.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl item = new FulfillmentGroupItemImpl();
    item.setOrderItem(orderItem);

    // Act and Assert
    assertFalse(simpleTaxProvider.isItemTaxable(item));
  }

  /**
   * Test {@link SimpleTaxProvider#isItemTaxable(FulfillmentGroupItem)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#isItemTaxable(FulfillmentGroupItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTaxProvider.isItemTaxable(FulfillmentGroupItem)"})
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
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#isFeeTaxable(FulfillmentGroupFee)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTaxProvider.isFeeTaxable(FulfillmentGroupFee)"})
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
   *
   * <ul>
   *   <li>When {@link FulfillmentGroupFeeImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#isFeeTaxable(FulfillmentGroupFee)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleTaxProvider.isFeeTaxable(FulfillmentGroupFee)"})
  public void testIsFeeTaxable_whenFulfillmentGroupFeeImpl_thenReturnFalse() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act and Assert
    assertFalse(simpleTaxProvider.isFeeTaxable(new FulfillmentGroupFeeImpl()));
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@link CountryImpl} (default constructor).
   *   <li>When {@link AddressImpl} (default constructor) Country is {@link CountryImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenCountryImpl_whenAddressImplCountryIsCountryImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());

    AddressImpl address = new AddressImpl();
    address.setCountry(new CountryImpl());

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
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
   *
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
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
   *
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
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
   *
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor) Name is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenISOCountryImplNameIs42MainSt() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation("42 Main St");

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
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(isoCountryAlpha2);
    address.setPostalCode("42 Main St");
    address.setCity("42 Main St");
    address.setState(state);
    address.setCountry(country);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor) Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenISOCountryImplNameIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName(null);

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation("42 Main St");

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
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(isoCountryAlpha2);
    address.setPostalCode("42 Main St");
    address.setCity("42 Main St");
    address.setState(state);
    address.setCountry(country);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AddressImpl} (default constructor) City is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenNull_whenAddressImplCityIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation("42 Main St");

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
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(isoCountryAlpha2);
    address.setPostalCode("42 Main St");
    address.setCity(null);
    address.setState(state);
    address.setCountry(country);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AddressImpl} (default constructor) PostalCode is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenNull_whenAddressImplPostalCodeIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultItemTaxRate(10.0d);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("42 Main St");
    isoCountryAlpha2.setName("42 Main St");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("42 Main St");
    state.setName("42 Main St");

    CountryImpl country = new CountryImpl();
    country.setName("Name");
    country.setAbbreviation("42 Main St");

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
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(isoCountryAlpha2);
    address.setPostalCode(null);
    address.setCity("42 Main St");
    address.setState(state);
    address.setCountry(country);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} (default constructor).
   *   <li>When {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenSimpleTaxProvider_whenAddressImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act
    BigDecimal actualDetermineItemTaxRateResult =
        simpleTaxProvider.determineItemTaxRate(new AddressImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenSimpleTaxProvider_whenNull() {
    // Arrange and Act
    BigDecimal actualDetermineItemTaxRateResult =
        new SimpleTaxProvider().determineItemTaxRate(null);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code Name}.
   *   <li>Then calls {@link State#getAbbreviation()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenStateGetNameReturnName_thenCallsGetAbbreviation() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());

    State state = mock(State.class);
    when(state.getName()).thenReturn("Name");
    when(state.getAbbreviation()).thenReturn("Abbreviation");

    AddressImpl address = new AddressImpl();
    address.setState(state);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state, atLeast(1)).getName();
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code null}.
   *   <li>Then calls {@link State#getAbbreviation()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenStateGetNameReturnNull_thenCallsGetAbbreviation() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());

    State state = mock(State.class);
    when(state.getName()).thenReturn(null);
    when(state.getAbbreviation()).thenReturn("Abbreviation");

    AddressImpl address = new AddressImpl();
    address.setState(state);

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state).getName();
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@link StateImpl} (default constructor).
   *   <li>When {@link AddressImpl} (default constructor) State is {@link StateImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_givenStateImpl_whenAddressImplStateIsStateImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());

    AddressImpl address = new AddressImpl();
    address.setState(new StateImpl());

    // Act
    BigDecimal actualDetermineItemTaxRateResult = simpleTaxProvider.determineItemTaxRate(address);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>Given {@code us-east-2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
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
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_whenAddressImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemStateTaxRateMap(new HashMap<>());

    // Act
    BigDecimal actualDetermineItemTaxRateResult =
        simpleTaxProvider.determineItemTaxRate(new AddressImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineItemTaxRate(Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SimpleTaxProvider#determineItemTaxRate(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal SimpleTaxProvider.determineItemTaxRate(Address)"})
  public void testDetermineItemTaxRate_whenAddressImpl2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setItemCountryTaxRateMap(new HashMap<>());

    // Act
    BigDecimal actualDetermineItemTaxRateResult =
        simpleTaxProvider.determineItemTaxRate(new AddressImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineItemTaxRateResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setStateProvinceRegion("us-east-2");

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(new ISOCountryImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup3() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    AddressImpl address = new AddressImpl();
    address.setStateProvinceRegion("");

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup4() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());

    AddressImpl address = new AddressImpl();
    address.setIsoCountryAlpha2(new ISOCountryImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImpl2() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImpl3() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImplCityIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(10.0d);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("Fulfillment Group");
    isoCountryAlpha2.setName("Fulfillment Group");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("Fulfillment Group");
    state.setName("Fulfillment Group");

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
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(isoCountryAlpha2);
    address.setPostalCode("Fulfillment Group");
    address.setCity(null);
    address.setState(state);
    address.setCountry(country);

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
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Country is {@link CountryImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImplCountryIsCountryImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());

    AddressImpl address = new AddressImpl();
    address.setCountry(new CountryImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PostalCode is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImplPostalCodeIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(10.0d);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("Fulfillment Group");
    isoCountryAlpha2.setName("Fulfillment Group");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("Fulfillment Group");
    state.setName("Fulfillment Group");

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
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(isoCountryAlpha2);
    address.setPostalCode(null);
    address.setCity("Fulfillment Group");
    address.setState(state);
    address.setCountry(country);

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
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) State is {@link StateImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenAddressImplStateIsStateImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());

    AddressImpl address = new AddressImpl();
    address.setState(new StateImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link ISOCountryImpl} (default constructor) Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenISOCountryImplNameIsNull() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(10.0d);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("Fulfillment Group");
    isoCountryAlpha2.setName(null);

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("Fulfillment Group");
    state.setName("Fulfillment Group");

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
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(isoCountryAlpha2);
    address.setPostalCode("Fulfillment Group");
    address.setCity("Fulfillment Group");
    address.setState(state);
    address.setCountry(country);

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
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link SimpleTaxProvider} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenSimpleTaxProvider() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setIsShippingPriceTaxable(null);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenStateGetNameReturnName() {
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
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state, atLeast(1)).getName();
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link State} {@link State#getName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenStateGetNameReturnNull() {
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
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    verify(state, atLeast(1)).getAbbreviation();
    verify(state).getName();
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_givenTrue() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setIsShippingPriceTaxable(true);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_thenReturnBigDecimalWith100() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();
    simpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCityTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupStateTaxRateMap(new HashMap<>());
    simpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(new HashMap<>());
    simpleTaxProvider.setDefaultFulfillmentGroupTaxRate(10.0d);

    ISOCountryImpl isoCountryAlpha2 = new ISOCountryImpl();
    isoCountryAlpha2.setAlpha3("Alpha3");
    isoCountryAlpha2.setNumericCode(10);
    isoCountryAlpha2.setStatus(new ISOCodeStatusType());
    isoCountryAlpha2.setAlpha2("Fulfillment Group");
    isoCountryAlpha2.setName("Fulfillment Group");

    StateImpl state = new StateImpl();
    state.setCountry(new CountryImpl());
    state.setAbbreviation("Fulfillment Group");
    state.setName("Fulfillment Group");

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
    address.setStateProvinceRegion("not blank");
    address.setIsoCountryAlpha2(isoCountryAlpha2);
    address.setPostalCode("Fulfillment Group");
    address.setCity("Fulfillment Group");
    address.setState(state);
    address.setCountry(country);

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
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setAddress(address);

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertEquals(new BigDecimal("10.0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test {@link SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SimpleTaxProvider#determineTaxRateForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal SimpleTaxProvider.determineTaxRateForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testDetermineTaxRateForFulfillmentGroup_whenFulfillmentGroupImpl() {
    // Arrange
    SimpleTaxProvider simpleTaxProvider = new SimpleTaxProvider();

    // Act
    BigDecimal actualDetermineTaxRateForFulfillmentGroupResult =
        simpleTaxProvider.determineTaxRateForFulfillmentGroup(new FulfillmentGroupImpl());

    // Assert
    assertEquals(new BigDecimal("0"), actualDetermineTaxRateForFulfillmentGroupResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleTaxProvider.<init>()",
    "void SimpleTaxProvider.cancelTax(Order, ModuleConfiguration)",
    "Double SimpleTaxProvider.getDefaultFulfillmentGroupTaxRate()",
    "Double SimpleTaxProvider.getDefaultItemTaxRate()",
    "Map SimpleTaxProvider.getFulfillmentGroupCityTaxRateMap()",
    "Map SimpleTaxProvider.getFulfillmentGroupCountryTaxRateMap()",
    "Map SimpleTaxProvider.getFulfillmentGroupPostalCodeTaxRateMap()",
    "Map SimpleTaxProvider.getFulfillmentGroupStateTaxRateMap()",
    "Map SimpleTaxProvider.getItemCityTaxRateMap()",
    "Map SimpleTaxProvider.getItemCountryTaxRateMap()",
    "Map SimpleTaxProvider.getItemPostalCodeTaxRateMap()",
    "Map SimpleTaxProvider.getItemStateTaxRateMap()",
    "void SimpleTaxProvider.setDefaultFulfillmentGroupTaxRate(Double)",
    "void SimpleTaxProvider.setDefaultItemTaxRate(Double)",
    "void SimpleTaxProvider.setFulfillmentGroupCityTaxRateMap(Map)",
    "void SimpleTaxProvider.setFulfillmentGroupCountryTaxRateMap(Map)",
    "void SimpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(Map)",
    "void SimpleTaxProvider.setFulfillmentGroupStateTaxRateMap(Map)",
    "void SimpleTaxProvider.setItemCityTaxRateMap(Map)",
    "void SimpleTaxProvider.setItemCountryTaxRateMap(Map)",
    "void SimpleTaxProvider.setItemPostalCodeTaxRateMap(Map)",
    "void SimpleTaxProvider.setItemStateTaxRateMap(Map)"
  })
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
    actualSimpleTaxProvider.setFulfillmentGroupPostalCodeTaxRateMap(
        fulfillmentGroupPostalCodeTaxRateMap);
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
    Double actualDefaultFulfillmentGroupTaxRate =
        actualSimpleTaxProvider.getDefaultFulfillmentGroupTaxRate();
    Double actualDefaultItemTaxRate = actualSimpleTaxProvider.getDefaultItemTaxRate();
    Map<String, Double> actualFulfillmentGroupCityTaxRateMap =
        actualSimpleTaxProvider.getFulfillmentGroupCityTaxRateMap();
    Map<String, Double> actualFulfillmentGroupCountryTaxRateMap =
        actualSimpleTaxProvider.getFulfillmentGroupCountryTaxRateMap();
    Map<String, Double> actualFulfillmentGroupPostalCodeTaxRateMap =
        actualSimpleTaxProvider.getFulfillmentGroupPostalCodeTaxRateMap();
    Map<String, Double> actualFulfillmentGroupStateTaxRateMap =
        actualSimpleTaxProvider.getFulfillmentGroupStateTaxRateMap();
    Map<String, Double> actualItemCityTaxRateMap = actualSimpleTaxProvider.getItemCityTaxRateMap();
    Map<String, Double> actualItemCountryTaxRateMap =
        actualSimpleTaxProvider.getItemCountryTaxRateMap();
    Map<String, Double> actualItemPostalCodeTaxRateMap =
        actualSimpleTaxProvider.getItemPostalCodeTaxRateMap();
    Map<String, Double> actualItemStateTaxRateMap =
        actualSimpleTaxProvider.getItemStateTaxRateMap();

    // Assert
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
