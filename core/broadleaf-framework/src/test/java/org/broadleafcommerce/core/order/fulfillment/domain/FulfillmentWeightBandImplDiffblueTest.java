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
package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.core.order.service.type.FulfillmentBandResultAmountType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FulfillmentWeightBandImplDiffblueTest {
  @Autowired
  private FulfillmentWeightBandImpl fulfillmentWeightBandImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentWeightBandImpl#setId(Long)}
   *   <li>{@link FulfillmentWeightBandImpl#setMinimumWeight(BigDecimal)}
   *   <li>{@link FulfillmentWeightBandImpl#setOption(BandedWeightFulfillmentOption)}
   *   <li>{@link FulfillmentWeightBandImpl#getId()}
   *   <li>{@link FulfillmentWeightBandImpl#getMinimumWeight()}
   *   <li>{@link FulfillmentWeightBandImpl#getOption()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long FulfillmentWeightBandImpl.getId()",
      "BigDecimal FulfillmentWeightBandImpl.getMinimumWeight()",
      "BandedWeightFulfillmentOption FulfillmentWeightBandImpl.getOption()",
      "void FulfillmentWeightBandImpl.setId(Long)", "void FulfillmentWeightBandImpl.setMinimumWeight(BigDecimal)",
      "void FulfillmentWeightBandImpl.setOption(BandedWeightFulfillmentOption)"})
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

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualMinimumWeight);
    assertSame(minimumWeight, actualMinimumWeight);
    assertSame(option, actualOption);
  }

  /**
   * Test {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   * <p>
   * Method under test: {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentWeightBandImpl.setWeightUnitOfMeasure(WeightUnitOfMeasureType)"})
  public void testSetWeightUnitOfMeasure() {
    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl2 = new FulfillmentWeightBandImpl();
    WeightUnitOfMeasureType weightUnitOfMeasure = new WeightUnitOfMeasureType("Type", "Friendly Type");

    // Act
    fulfillmentWeightBandImpl2.setWeightUnitOfMeasure(weightUnitOfMeasure);

    // Assert
    assertEquals("Type", fulfillmentWeightBandImpl2.weightUnitOfMeasure);
    assertEquals(weightUnitOfMeasure, fulfillmentWeightBandImpl2.getWeightUnitOfMeasure());
  }

  /**
   * Test {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>Given {@link FulfillmentWeightBandImpl} (default constructor) Id is one.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentWeightBandImpl.setWeightUnitOfMeasure(WeightUnitOfMeasureType)"})
  public void testSetWeightUnitOfMeasure_givenFulfillmentWeightBandImplIdIsOne_whenNull() {
    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl2 = new FulfillmentWeightBandImpl();
    fulfillmentWeightBandImpl2.setId(1L);
    fulfillmentWeightBandImpl2.setMinimumWeight(new BigDecimal("2.3"));
    fulfillmentWeightBandImpl2.setOption(new BandedWeightFulfillmentOptionImpl());
    fulfillmentWeightBandImpl2.setResultAmount(new BigDecimal("2.3"));
    fulfillmentWeightBandImpl2.setResultAmountType(FulfillmentBandResultAmountType.PERCENTAGE);
    fulfillmentWeightBandImpl2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act
    fulfillmentWeightBandImpl2.setWeightUnitOfMeasure(null);

    // Assert that nothing has changed
    assertEquals("Type", fulfillmentWeightBandImpl2.getWeightUnitOfMeasure().getType());
    assertEquals("Type", fulfillmentWeightBandImpl2.weightUnitOfMeasure);
  }

  /**
   * Test {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then calls {@link WeightUnitOfMeasureType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentWeightBandImpl.setWeightUnitOfMeasure(WeightUnitOfMeasureType)"})
  public void testSetWeightUnitOfMeasure_givenType_thenCallsGetType() {
    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl2 = new FulfillmentWeightBandImpl();
    WeightUnitOfMeasureType weightUnitOfMeasure = mock(WeightUnitOfMeasureType.class);
    when(weightUnitOfMeasure.getType()).thenReturn("Type");

    // Act
    fulfillmentWeightBandImpl2.setWeightUnitOfMeasure(weightUnitOfMeasure);

    // Assert
    verify(weightUnitOfMeasure).getType();
    assertEquals("Type", fulfillmentWeightBandImpl2.getWeightUnitOfMeasure().getType());
    assertEquals("Type", fulfillmentWeightBandImpl2.weightUnitOfMeasure);
  }
}
