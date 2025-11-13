package org.broadleafcommerce.core.pricing.service.fulfillment.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.vendor.service.exception.FulfillmentPriceException;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.fulfillment.domain.FixedPriceFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FixedPriceFulfillmentPricingProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FixedPriceFulfillmentPricingProviderDiffblueTest {
  @Autowired private FixedPriceFulfillmentPricingProvider fixedPriceFulfillmentPricingProvider;

  /**
   * Test {@link
   * FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup,
   * FulfillmentOption)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup,
   * FulfillmentOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)"
  })
  public void testCanCalculateCostForFulfillmentGroup_thenReturnFalse() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertFalse(
        fixedPriceFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(
            fulfillmentGroup, new FulfillmentOptionImpl()));
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup,
   * FulfillmentOption)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentPricingProvider#canCalculateCostForFulfillmentGroup(FulfillmentGroup,
   * FulfillmentOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FixedPriceFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(FulfillmentGroup, FulfillmentOption)"
  })
  public void testCanCalculateCostForFulfillmentGroup_thenReturnTrue() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(
        fixedPriceFulfillmentPricingProvider.canCalculateCostForFulfillmentGroup(
            fulfillmentGroup, new FixedPriceFulfillmentOptionImpl()));
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FixedPriceFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testCalculateCostForFulfillmentGroup_thenReturnFulfillmentGroupImpl()
      throws FulfillmentPriceException {
    // Arrange
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
    fulfillmentGroup.setFulfillmentOption(new FixedPriceFulfillmentOptionImpl());

    // Act
    FulfillmentGroup actualCalculateCostForFulfillmentGroupResult =
        fixedPriceFulfillmentPricingProvider.calculateCostForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertSame(fulfillmentGroup, actualCalculateCostForFulfillmentGroupResult);
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentPricingProvider#calculateCostForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FixedPriceFulfillmentPricingProvider.calculateCostForFulfillmentGroup(FulfillmentGroup)"
  })
  public void testCalculateCostForFulfillmentGroup_thenThrowIllegalArgumentException()
      throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fixedPriceFulfillmentPricingProvider.calculateCostForFulfillmentGroup(
                fulfillmentGroup));
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentOptionImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse FixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup_givenFulfillmentOptionImpl()
      throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    LinkedHashSet<FulfillmentOption> options = new LinkedHashSet<>();
    options.add(new FulfillmentOptionImpl());

    // Act and Assert
    assertTrue(
        fixedPriceFulfillmentPricingProvider
            .estimateCostForFulfillmentGroup(fulfillmentGroup, options)
            .getFulfillmentOptionPrices()
            .isEmpty());
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   *
   * <ul>
   *   <li>Then return FulfillmentOptionPrices size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse FixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup_thenReturnFulfillmentOptionPricesSizeIsOne()
      throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    LinkedHashSet<FulfillmentOption> options = new LinkedHashSet<>();
    options.add(new FixedPriceFulfillmentOptionImpl());

    // Act and Assert
    assertEquals(
        1,
        fixedPriceFulfillmentPricingProvider
            .estimateCostForFulfillmentGroup(fulfillmentGroup, options)
            .getFulfillmentOptionPrices()
            .size());
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse FixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup_thenThrowIllegalArgumentException()
      throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl =
        mock(FixedPriceFulfillmentOptionImpl.class);
    when(fixedPriceFulfillmentOptionImpl.getPrice()).thenThrow(new IllegalArgumentException());

    LinkedHashSet<FulfillmentOption> options = new LinkedHashSet<>();
    options.add(fixedPriceFulfillmentOptionImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            fixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(
                fulfillmentGroup, options));
    verify(fixedPriceFulfillmentOptionImpl).getPrice();
  }

  /**
   * Test {@link
   * FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FixedPriceFulfillmentPricingProvider#estimateCostForFulfillmentGroup(FulfillmentGroup, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.pricing.service.fulfillment.provider.FulfillmentEstimationResponse FixedPriceFulfillmentPricingProvider.estimateCostForFulfillmentGroup(FulfillmentGroup, Set)"
  })
  public void testEstimateCostForFulfillmentGroup_whenHashSet() throws FulfillmentPriceException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertTrue(
        fixedPriceFulfillmentPricingProvider
            .estimateCostForFulfillmentGroup(fulfillmentGroup, new HashSet<>())
            .getFulfillmentOptionPrices()
            .isEmpty());
  }
}
