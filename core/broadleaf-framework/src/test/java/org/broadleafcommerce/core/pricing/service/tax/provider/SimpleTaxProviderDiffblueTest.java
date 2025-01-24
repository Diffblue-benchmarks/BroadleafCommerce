package org.broadleafcommerce.core.pricing.service.tax.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.i18n.domain.ISOCountry;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.TaxException;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.Test;

public class SimpleTaxProviderDiffblueTest {
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
