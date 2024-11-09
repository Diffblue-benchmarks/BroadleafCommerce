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
package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.core.order.service.type.FulfillmentBandResultAmountType;
import org.junit.Test;

public class FulfillmentWeightBandImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentWeightBandImpl#setId(Long)}
   *   <li>{@link FulfillmentWeightBandImpl#setMinimumWeight(BigDecimal)}
   *   <li>
   * {@link FulfillmentWeightBandImpl#setOption(BandedWeightFulfillmentOption)}
   *   <li>{@link FulfillmentWeightBandImpl#getId()}
   *   <li>{@link FulfillmentWeightBandImpl#getMinimumWeight()}
   *   <li>{@link FulfillmentWeightBandImpl#getOption()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl = new FulfillmentWeightBandImpl();

    // Act
    fulfillmentWeightBandImpl.setId(1L);
    BigDecimal minimumWeight = new BigDecimal("2.3");
    fulfillmentWeightBandImpl.setMinimumWeight(minimumWeight);
    BandedWeightFulfillmentOptionImpl option = new BandedWeightFulfillmentOptionImpl();
    fulfillmentWeightBandImpl.setOption(option);
    Long actualId = fulfillmentWeightBandImpl.getId();
    BigDecimal actualMinimumWeight = fulfillmentWeightBandImpl.getMinimumWeight();
    BandedWeightFulfillmentOption actualOption = fulfillmentWeightBandImpl.getOption();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualMinimumWeight);
    assertSame(minimumWeight, actualMinimumWeight);
    assertSame(option, actualOption);
  }

  /**
   * Test
   * {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   * <p>
   * Method under test:
   * {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  public void testSetWeightUnitOfMeasure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl = new FulfillmentWeightBandImpl();
    WeightUnitOfMeasureType weightUnitOfMeasure = new WeightUnitOfMeasureType("Type", "Friendly Type");

    // Act
    fulfillmentWeightBandImpl.setWeightUnitOfMeasure(weightUnitOfMeasure);

    // Assert
    assertEquals("Type", fulfillmentWeightBandImpl.weightUnitOfMeasure);
    assertEquals(weightUnitOfMeasure, fulfillmentWeightBandImpl.getWeightUnitOfMeasure());
  }

  /**
   * Test
   * {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>Given {@link FulfillmentWeightBandImpl} (default constructor) Id is
   * one.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  public void testSetWeightUnitOfMeasure_givenFulfillmentWeightBandImplIdIsOne_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl = new FulfillmentWeightBandImpl();
    fulfillmentWeightBandImpl.setId(1L);
    fulfillmentWeightBandImpl.setMinimumWeight(new BigDecimal("2.3"));
    fulfillmentWeightBandImpl.setOption(new BandedWeightFulfillmentOptionImpl());
    fulfillmentWeightBandImpl.setResultAmount(new BigDecimal("2.3"));
    fulfillmentWeightBandImpl.setResultAmountType(FulfillmentBandResultAmountType.PERCENTAGE);
    fulfillmentWeightBandImpl.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act
    fulfillmentWeightBandImpl.setWeightUnitOfMeasure(null);

    // Assert that nothing has changed
    assertEquals("Type", fulfillmentWeightBandImpl.getWeightUnitOfMeasure().getType());
    assertEquals("Type", fulfillmentWeightBandImpl.weightUnitOfMeasure);
  }

  /**
   * Test
   * {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then calls {@link WeightUnitOfMeasureType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  public void testSetWeightUnitOfMeasure_givenType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl = new FulfillmentWeightBandImpl();
    WeightUnitOfMeasureType weightUnitOfMeasure = mock(WeightUnitOfMeasureType.class);
    when(weightUnitOfMeasure.getType()).thenReturn("Type");

    // Act
    fulfillmentWeightBandImpl.setWeightUnitOfMeasure(weightUnitOfMeasure);

    // Assert
    verify(weightUnitOfMeasure).getType();
    assertEquals("Type", fulfillmentWeightBandImpl.getWeightUnitOfMeasure().getType());
    assertEquals("Type", fulfillmentWeightBandImpl.weightUnitOfMeasure);
  }
}
