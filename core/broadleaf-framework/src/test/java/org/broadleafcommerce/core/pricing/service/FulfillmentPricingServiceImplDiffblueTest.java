package org.broadleafcommerce.core.pricing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.vendor.service.exception.FulfillmentPriceException;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.fulfillment.domain.BandedPriceFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.BandedFulfillmentPricingProvider;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse;
import org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentPricingProvider;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class FulfillmentPricingServiceImplDiffblueTest {
  @InjectMocks private FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl;

  @Mock private List<FulfillmentPricingProvider> list;

  /**
   * Test {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testCalculateCostForFulfillmentGroup_thenOrderReturnNullOrderImpl()
      throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(new BandedFulfillmentPricingProvider());

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl =
        new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);

    BandedPriceFulfillmentOptionImpl fulfillmentOption = new BandedPriceFulfillmentOptionImpl();
    fulfillmentOption.setBands(new ArrayList<>());
    fulfillmentOption.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOption.setId(1L);
    fulfillmentOption.setLongDescription(
        "No valid processor was found to calculate the FulfillmentGroup cost with FulfillmentOption id: ");
    fulfillmentOption.setName(
        "No valid processor was found to calculate the FulfillmentGroup cost with FulfillmentOption id: ");
    fulfillmentOption.setTaxCode(
        "No valid processor was found to calculate the FulfillmentGroup cost with FulfillmentOption id: ");
    fulfillmentOption.setTaxable(true);
    fulfillmentOption.setUseFlatRates(true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    AddressImpl address = new AddressImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    Money fulfillmentPrice = new Money();
    fulfillmentGroup.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    NullOrderImpl order = new NullOrderImpl();
    fulfillmentGroup.setOrder(order);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    fulfillmentGroup.setPersonalMessage(personalMessage);
    PhoneImpl phone = new PhoneImpl();
    fulfillmentGroup.setPhone(phone);
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
    fulfillmentGroup.setFulfillmentOption(fulfillmentOption);

    // Act
    FulfillmentGroup actualCalculateCostForFulfillmentGroupResult =
        fulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertTrue(actualCalculateCostForFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    Order order2 = actualCalculateCostForFulfillmentGroupResult.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    PersonalMessage personalMessage2 =
        actualCalculateCostForFulfillmentGroupResult.getPersonalMessage();
    assertTrue(personalMessage2 instanceof PersonalMessageImpl);
    FulfillmentOption fulfillmentOption2 =
        actualCalculateCostForFulfillmentGroupResult.getFulfillmentOption();
    assertTrue(fulfillmentOption2 instanceof BandedPriceFulfillmentOptionImpl);
    Address address2 = actualCalculateCostForFulfillmentGroupResult.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    Phone phone2 = actualCalculateCostForFulfillmentGroupResult.getPhone();
    assertTrue(phone2 instanceof PhoneImpl);
    assertEquals("42", actualCalculateCostForFulfillmentGroupResult.getReferenceNumber());
    assertEquals(
        "Delivery Instruction",
        actualCalculateCostForFulfillmentGroupResult.getDeliveryInstruction());
    assertEquals("Fulfillment Method", actualCalculateCostForFulfillmentGroupResult.getMethod());
    assertEquals("Service", actualCalculateCostForFulfillmentGroupResult.getService());
    assertNull(
        ((FulfillmentGroupImpl) actualCalculateCostForFulfillmentGroupResult).getCurrencyCode());
    assertEquals(1, actualCalculateCostForFulfillmentGroupResult.getSequence().intValue());
    assertEquals(1L, actualCalculateCostForFulfillmentGroupResult.getId().longValue());
    assertTrue(actualCalculateCostForFulfillmentGroupResult.getShippingOverride());
    assertTrue(actualCalculateCostForFulfillmentGroupResult.isPrimary());
    assertTrue(actualCalculateCostForFulfillmentGroupResult.isShippingPriceTaxable());
    assertEquals(
        fulfillmentPrice,
        actualCalculateCostForFulfillmentGroupResult.getFulfillmentGroupAdjustmentsValue());
    assertEquals(
        fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getFulfillmentPrice());
    assertEquals(
        fulfillmentPrice,
        actualCalculateCostForFulfillmentGroupResult
            .getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(
        fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getMerchandiseTotal());
    assertEquals(
        fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getRetailFulfillmentPrice());
    assertEquals(
        fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getRetailShippingPrice());
    assertEquals(
        fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getSaleFulfillmentPrice());
    assertEquals(
        fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getSaleShippingPrice());
    assertEquals(fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getShippingPrice());
    assertEquals(fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getTotal());
    assertEquals(fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getTotalFeeTax());
    assertEquals(
        fulfillmentPrice,
        actualCalculateCostForFulfillmentGroupResult.getTotalFulfillmentGroupTax());
    assertEquals(fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getTotalItemTax());
    assertEquals(fulfillmentPrice, actualCalculateCostForFulfillmentGroupResult.getTotalTax());
    assertSame(order, order2);
    assertSame(personalMessage, personalMessage2);
    assertSame(fulfillmentOption, fulfillmentOption2);
    assertSame(address, address2);
    assertSame(phone, phone2);
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then return Sequence is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testCalculateCostForFulfillmentGroup_thenReturnSequenceIsNull()
      throws FulfillmentPriceException {
    // Arrange
    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl =
        new FulfillmentPricingServiceImpl();

    // Act
    FulfillmentGroup actualCalculateCostForFulfillmentGroupResult =
        fulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(new FulfillmentGroupImpl());

    // Assert
    assertTrue(actualCalculateCostForFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    assertNull(actualCalculateCostForFulfillmentGroupResult.getSequence());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getId());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getDeliveryInstruction());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getMethod());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getReferenceNumber());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getService());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getMerchandiseTotal());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getTotal());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getTotalFeeTax());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getTotalFulfillmentGroupTax());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getTotalItemTax());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getTotalTax());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getFulfillmentOption());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getOrder());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getPersonalMessage());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getStatus());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getType());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getAddress());
    assertNull(actualCalculateCostForFulfillmentGroupResult.getPhone());
    assertFalse(actualCalculateCostForFulfillmentGroupResult.getShippingOverride());
    assertFalse(actualCalculateCostForFulfillmentGroupResult.isPrimary());
    assertFalse(actualCalculateCostForFulfillmentGroupResult.isShippingPriceTaxable());
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link FulfillmentPriceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentPricingServiceImpl#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testCalculateCostForFulfillmentGroup_thenThrowFulfillmentPriceException()
      throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(new BandedFulfillmentPricingProvider());

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl =
        new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(1L);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
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
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());

    // Act and Assert
    assertThrows(
        FulfillmentPriceException.class,
        () -> fulfillmentPricingServiceImpl.calculateCostForFulfillmentGroup(fulfillmentGroup));
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup,
   * Set)}.
   *
   * <p>Method under test: {@link
   * FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup() throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(new BandedFulfillmentPricingProvider());

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl =
        new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(
        fulfillmentPricingServiceImpl
            .estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
            .getFulfillmentOptionPrices()
            .isEmpty());
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup,
   * Set)}.
   *
   * <p>Method under test: {@link
   * FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup2() throws FulfillmentPriceException {
    // Arrange
    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider =
        mock(BandedFulfillmentPricingProvider.class);
    when(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(
            Mockito.<FulfillmentGroup>any(), Mockito.<Set<FulfillmentOption>>any()))
        .thenThrow(new FulfillmentPriceException());

    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(bandedFulfillmentPricingProvider);

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl =
        new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    FulfillmentEstimationResponse actualEstimateCostForFulfillmentGroupResult =
        fulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(
            fulfillmentGroup, new HashSet<>());

    // Assert
    verify(bandedFulfillmentPricingProvider)
        .estimateCostForFulfillmentGroup(isA(FulfillmentGroup.class), isA(Set.class));
    assertTrue(actualEstimateCostForFulfillmentGroupResult.getFulfillmentOptionPrices().isEmpty());
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup,
   * Set)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup_thenCallsIterator()
      throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> fulfillmentPricingProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(fulfillmentPricingProviderList.iterator());
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(new FulfillmentOptionImpl());

    // Act
    FulfillmentEstimationResponse actualEstimateCostForFulfillmentGroupResult =
        fulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(fulfillmentGroup, options);

    // Assert
    verify(list).iterator();
    assertTrue(actualEstimateCostForFulfillmentGroupResult.getFulfillmentOptionPrices().isEmpty());
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup,
   * Set)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup_thenCallsIterator2()
      throws FulfillmentPriceException {
    // Arrange
    ArrayList<FulfillmentPricingProvider> fulfillmentPricingProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(fulfillmentPricingProviderList.iterator());
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl =
        new BandedPriceFulfillmentOptionImpl();
    bandedPriceFulfillmentOptionImpl.setBands(new ArrayList<>());
    bandedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedPriceFulfillmentOptionImpl.setId(1L);
    bandedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    bandedPriceFulfillmentOptionImpl.setName("Name");
    bandedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    bandedPriceFulfillmentOptionImpl.setTaxable(true);
    bandedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    HashSet<FulfillmentOption> options = new HashSet<>();
    options.add(bandedPriceFulfillmentOptionImpl);
    options.add(new FulfillmentOptionImpl());

    // Act
    FulfillmentEstimationResponse actualEstimateCostForFulfillmentGroupResult =
        fulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(fulfillmentGroup, options);

    // Assert
    verify(list).iterator();
    assertTrue(actualEstimateCostForFulfillmentGroupResult.getFulfillmentOptionPrices().isEmpty());
  }

  /**
   * Test {@link FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup,
   * Set)}.
   *
   * <ul>
   *   <li>Then return FulfillmentOptionPrices size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentPricingServiceImpl#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentEstimationResponse FulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup_thenReturnFulfillmentOptionPricesSizeIsOne()
      throws FulfillmentPriceException {
    // Arrange
    HashMap<FulfillmentOption, Money> fulfillmentOptionPrices = new HashMap<>();
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionPrices.put(fulfillmentOptionImpl, new Money());

    FulfillmentEstimationResponse fulfillmentEstimationResponse =
        new FulfillmentEstimationResponse();
    fulfillmentEstimationResponse.setFulfillmentOptionPrices(fulfillmentOptionPrices);

    BandedFulfillmentPricingProvider bandedFulfillmentPricingProvider =
        mock(BandedFulfillmentPricingProvider.class);
    when(bandedFulfillmentPricingProvider.estimateCostForFulfillmentGroup(
            Mockito.<FulfillmentGroup>any(), Mockito.<Set<FulfillmentOption>>any()))
        .thenReturn(fulfillmentEstimationResponse);

    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();
    providers.add(bandedFulfillmentPricingProvider);

    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl =
        new FulfillmentPricingServiceImpl();
    fulfillmentPricingServiceImpl.setProviders(providers);
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    FulfillmentEstimationResponse actualEstimateCostForFulfillmentGroupResult =
        fulfillmentPricingServiceImpl.estimateCostForFulfillmentGroup(
            fulfillmentGroup, new HashSet<>());

    // Assert
    verify(bandedFulfillmentPricingProvider)
        .estimateCostForFulfillmentGroup(isA(FulfillmentGroup.class), isA(Set.class));
    assertEquals(
        1, actualEstimateCostForFulfillmentGroupResult.getFulfillmentOptionPrices().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentPricingServiceImpl#setProviders(List)}
   *   <li>{@link FulfillmentPricingServiceImpl#getProviders()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentPricingServiceImpl.getProviders()",
    "void FulfillmentPricingServiceImpl.setProviders(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentPricingServiceImpl fulfillmentPricingServiceImpl =
        new FulfillmentPricingServiceImpl();
    ArrayList<FulfillmentPricingProvider> providers = new ArrayList<>();

    // Act
    fulfillmentPricingServiceImpl.setProviders(providers);
    List<FulfillmentPricingProvider> actualProviders = fulfillmentPricingServiceImpl.getProviders();

    // Assert
    assertTrue(actualProviders.isEmpty());
    assertSame(providers, actualProviders);
  }
}
