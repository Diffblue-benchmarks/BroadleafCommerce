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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.NotImplementedException;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BandedShippingModuleDiffblueTest {
  @InjectMocks
  private BandedShippingModule bandedShippingModule;

  /**
   * Test {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup BandedShippingModule.calculateShippingForFulfillmentGroup(FulfillmentGroup)"})
  public void testCalculateShippingForFulfillmentGroup_thenOrderReturnNullOrderImpl() {
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
    Order order2 = actualCalculateShippingForFulfillmentGroupResult.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertNull(((FulfillmentGroupImpl) actualCalculateShippingForFulfillmentGroupResult).getCurrencyCode());
    assertSame(order, order2);
  }

  /**
   * Test {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return FulfillmentPrice is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup BandedShippingModule.calculateShippingForFulfillmentGroup(FulfillmentGroup)"})
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
   * Test {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then throw {@link NotImplementedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroup BandedShippingModule.calculateShippingForFulfillmentGroup(FulfillmentGroup)"})
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
   * <p>
   * Method under test: {@link BandedShippingModule#getServiceName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BandedShippingModule.getServiceName()"})
  public void testGetServiceName() {
    // Arrange, Act and Assert
    assertEquals("BANDED_SHIPPING", (new BandedShippingModule()).getServiceName());
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <ul>
   *   <li>When {@code BANDED_SHIPPING}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean BandedShippingModule.isValidModuleForService(String)"})
  public void testIsValidModuleForService_whenBandedShipping_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(bandedShippingModule.isValidModuleForService("BANDED_SHIPPING"));
  }

  /**
   * Test {@link BandedShippingModule#isValidModuleForService(String)}.
   * <ul>
   *   <li>When {@code Service Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BandedShippingModule#isValidModuleForService(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean BandedShippingModule.isValidModuleForService(String)"})
  public void testIsValidModuleForService_whenServiceName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(bandedShippingModule.isValidModuleForService("Service Name"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BandedShippingModule.<init>()", "Map BandedShippingModule.getFeeSubTypeMapping()",
      "Map BandedShippingModule.getFeeTypeMapping()", "String BandedShippingModule.getName()",
      "Boolean BandedShippingModule.isDefaultModule()", "void BandedShippingModule.setDefaultModule(Boolean)",
      "void BandedShippingModule.setFeeSubTypeMapping(Map)", "void BandedShippingModule.setFeeTypeMapping(Map)",
      "void BandedShippingModule.setName(String)"})
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

    // Assert
    assertEquals("Name", actualName);
    assertTrue(actualFeeSubTypeMapping.isEmpty());
    assertTrue(actualFeeTypeMapping.isEmpty());
    assertTrue(actualIsDefaultModuleResult);
    assertSame(feeSubTypeMapping, actualFeeSubTypeMapping);
    assertSame(feeTypeMapping, actualFeeTypeMapping);
  }
}
