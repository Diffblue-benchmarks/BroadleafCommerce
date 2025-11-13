package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentWeightBandImplDiffblueTest {
  @Autowired private FulfillmentWeightBandImpl fulfillmentWeightBandImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FulfillmentWeightBandImpl.getId()",
    "BigDecimal FulfillmentWeightBandImpl.getMinimumWeight()",
    "BandedWeightFulfillmentOption FulfillmentWeightBandImpl.getOption()",
    "void FulfillmentWeightBandImpl.setId(Long)",
    "void FulfillmentWeightBandImpl.setMinimumWeight(BigDecimal)",
    "void FulfillmentWeightBandImpl.setOption(BandedWeightFulfillmentOption)"
  })
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
   * Test {@link FulfillmentWeightBandImpl#getWeightUnitOfMeasure()}.
   *
   * <p>Method under test: {@link FulfillmentWeightBandImpl#getWeightUnitOfMeasure()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WeightUnitOfMeasureType FulfillmentWeightBandImpl.getWeightUnitOfMeasure()"})
  public void testGetWeightUnitOfMeasure() {
    // Arrange, Act and Assert
    assertNull(fulfillmentWeightBandImpl.getWeightUnitOfMeasure());
  }

  /**
   * Test {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentWeightBandImpl.setWeightUnitOfMeasure(WeightUnitOfMeasureType)"
  })
  public void testSetWeightUnitOfMeasure_whenNull() {
    // Arrange and Act
    fulfillmentWeightBandImpl.setWeightUnitOfMeasure(null);

    // Assert that nothing has changed
    assertNull(fulfillmentWeightBandImpl.weightUnitOfMeasure);
  }

  /**
   * Test {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>When {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentWeightBandImpl.setWeightUnitOfMeasure(WeightUnitOfMeasureType)"
  })
  public void testSetWeightUnitOfMeasure_whenWeightUnitOfMeasureType() {
    // Arrange and Act
    fulfillmentWeightBandImpl.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Assert that nothing has changed
    assertNull(fulfillmentWeightBandImpl.weightUnitOfMeasure);
  }

  /**
   * Test new {@link FulfillmentWeightBandImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FulfillmentWeightBandImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentWeightBandImpl.<init>()"})
  public void testNewFulfillmentWeightBandImpl() {
    // Arrange and Act
    FulfillmentWeightBandImpl actualFulfillmentWeightBandImpl = new FulfillmentWeightBandImpl();

    // Assert
    FulfillmentBandResultAmountType resultAmountType =
        actualFulfillmentWeightBandImpl.getResultAmountType();
    assertEquals("RATE", resultAmountType.getType());
    assertEquals("RATE", actualFulfillmentWeightBandImpl.resultAmountType);
    assertEquals("Rate", resultAmountType.getFriendlyType());
    assertNull(actualFulfillmentWeightBandImpl.getId());
    assertNull(actualFulfillmentWeightBandImpl.weightUnitOfMeasure);
    assertNull(actualFulfillmentWeightBandImpl.getResultAmount());
    assertNull(actualFulfillmentWeightBandImpl.getMinimumWeight());
    assertNull(actualFulfillmentWeightBandImpl.getWeightUnitOfMeasure());
    assertNull(actualFulfillmentWeightBandImpl.getOption());
  }
}
