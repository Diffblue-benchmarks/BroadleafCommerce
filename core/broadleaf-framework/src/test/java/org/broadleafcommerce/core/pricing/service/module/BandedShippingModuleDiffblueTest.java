package org.broadleafcommerce.core.pricing.service.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.lang.NotImplementedException;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.pricing.service.ShippingRateService;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BandedShippingModule.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BandedShippingModuleDiffblueTest {
  @Autowired
  private BandedShippingModule bandedShippingModule;

  @MockBean
  private ShippingRateService shippingRateService;

  /**
   * Test
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateShippingForFulfillmentGroup() {
    // Arrange
    BandedShippingModule bandedShippingModule = new BandedShippingModule();
    bandedShippingModule.setDefaultModule(true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    fulfillmentGroup.setOrder(order);

    // Act
    FulfillmentGroup actualCalculateShippingForFulfillmentGroupResult = bandedShippingModule
        .calculateShippingForFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertTrue(actualCalculateShippingForFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    Money fulfillmentGroupAdjustmentsValue = actualCalculateShippingForFulfillmentGroupResult
        .getFulfillmentGroupAdjustmentsValue();
    Currency currency = fulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(((FulfillmentGroupImpl) actualCalculateShippingForFulfillmentGroupResult).getCurrencyCode());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, fulfillmentGroupAdjustmentsValue.getAmount());
    assertEquals(fulfillmentGroupAdjustmentsValue, fulfillmentGroupAdjustmentsValue.abs());
    assertEquals(fulfillmentGroupAdjustmentsValue, fulfillmentGroupAdjustmentsValue.zero());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getFulfillmentPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getRetailFulfillmentPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getRetailShippingPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getSaleFulfillmentPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue,
        actualCalculateShippingForFulfillmentGroupResult.getSaleShippingPrice());
    assertEquals(fulfillmentGroupAdjustmentsValue, actualCalculateShippingForFulfillmentGroupResult.getShippingPrice());
    assertSame(order, actualCalculateShippingForFulfillmentGroupResult.getOrder());
  }

  /**
   * Test
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return FulfillmentPrice is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateShippingForFulfillmentGroup_thenReturnFulfillmentPriceIsNull() {
    // Arrange
    BandedShippingModule bandedShippingModule = new BandedShippingModule();

    // Act
    FulfillmentGroup actualCalculateShippingForFulfillmentGroupResult = bandedShippingModule
        .calculateShippingForFulfillmentGroup(new FulfillmentGroupImpl());

    // Assert
    assertTrue(actualCalculateShippingForFulfillmentGroupResult instanceof FulfillmentGroupImpl);
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getFulfillmentPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getRetailFulfillmentPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getRetailShippingPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getSaleFulfillmentPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getSaleShippingPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getShippingPrice());
    assertNull(actualCalculateShippingForFulfillmentGroupResult.getOrder());
  }

  /**
   * Test
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then throw {@link NotImplementedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateShippingForFulfillmentGroup_thenThrowNotImplementedException() {
    // Arrange
    BandedShippingModule bandedShippingModule = new BandedShippingModule();
    bandedShippingModule.setDefaultModule(true);
    State state = mock(State.class);
    when(state.getAbbreviation()).thenThrow(new NotImplementedException());

    AddressImpl address = new AddressImpl();
    address.setState(state);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(address);
    fulfillmentGroup.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    // Act and Assert
    assertThrows(NotImplementedException.class,
        () -> bandedShippingModule.calculateShippingForFulfillmentGroup(fulfillmentGroup));
    verify(state).getAbbreviation();
  }

  /**
   * Test {@link BandedShippingModule#getServiceName()}.
   * <ul>
   *   <li>Given {@link BandedShippingModule} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#getServiceName()}
   */
  @Test
  public void testGetServiceName_givenBandedShippingModule() {
    // Arrange, Act and Assert
    assertEquals("BANDED_SHIPPING", (new BandedShippingModule()).getServiceName());
  }

  /**
   * Test {@link BandedShippingModule#getServiceName()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#getServiceName()}
   */
  @Test
  public void testGetServiceName_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> feeTypeMapping = new HashMap<>();
    feeTypeMapping.computeIfPresent("foo", mock(BiFunction.class));

    BandedShippingModule bandedShippingModule = new BandedShippingModule();
    bandedShippingModule.setFeeTypeMapping(feeTypeMapping);

    // Act and Assert
    assertEquals("BANDED_SHIPPING", bandedShippingModule.getServiceName());
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <p>
   * Method under test:
   * {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsValidModuleForService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.pricing.service.module;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.pricing.service.module.BandedShippingModule.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3846 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.module.BandedShippingModule bandedShippingModule;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.pricing.service.ShippingRateService shippingRateService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    bandedShippingModule.isValidModuleForService("Service Name");
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <ul>
   *   <li>Given {@link BandedShippingModule} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  public void testIsValidModuleForService_givenBandedShippingModule_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BandedShippingModule()).isValidModuleForService("Service Name"));
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  public void testIsValidModuleForService_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String> feeTypeMapping = new HashMap<>();
    feeTypeMapping.computeIfPresent("foo", mock(BiFunction.class));

    BandedShippingModule bandedShippingModule = new BandedShippingModule();
    bandedShippingModule.setFeeTypeMapping(feeTypeMapping);

    // Act and Assert
    assertFalse(bandedShippingModule.isValidModuleForService("Service Name"));
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <ul>
   *   <li>When {@code BANDED_SHIPPING}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  public void testIsValidModuleForService_whenBandedShipping_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BandedShippingModule()).isValidModuleForService("BANDED_SHIPPING"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BandedShippingModule}
   *   <li>{@link BandedShippingModule#setDefaultModule(Boolean)}
   *   <li>{@link BandedShippingModule#setFeeSubTypeMapping(Map)}
   *   <li>{@link BandedShippingModule#setFeeTypeMapping(Map)}
   *   <li>{@link BandedShippingModule#setName(String)}
   *   <li>{@link BandedShippingModule#getFeeSubTypeMapping()}
   *   <li>{@link BandedShippingModule#getFeeTypeMapping()}
   *   <li>{@link BandedShippingModule#getName()}
   *   <li>{@link BandedShippingModule#isDefaultModule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BandedShippingModule actualBandedShippingModule = new BandedShippingModule();
    actualBandedShippingModule.setDefaultModule(true);
    HashMap<String, String> feeSubTypeMapping = new HashMap<>();
    actualBandedShippingModule.setFeeSubTypeMapping(feeSubTypeMapping);
    HashMap<String, String> feeTypeMapping = new HashMap<>();
    actualBandedShippingModule.setFeeTypeMapping(feeTypeMapping);
    actualBandedShippingModule.setName("Name");
    Map<String, String> actualFeeSubTypeMapping = actualBandedShippingModule.getFeeSubTypeMapping();
    Map<String, String> actualFeeTypeMapping = actualBandedShippingModule.getFeeTypeMapping();
    String actualName = actualBandedShippingModule.getName();
    Boolean actualIsDefaultModuleResult = actualBandedShippingModule.isDefaultModule();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertTrue(actualFeeSubTypeMapping.isEmpty());
    assertTrue(actualFeeTypeMapping.isEmpty());
    assertTrue(actualIsDefaultModuleResult);
    assertSame(feeSubTypeMapping, actualFeeSubTypeMapping);
    assertSame(feeTypeMapping, actualFeeTypeMapping);
  }
}
