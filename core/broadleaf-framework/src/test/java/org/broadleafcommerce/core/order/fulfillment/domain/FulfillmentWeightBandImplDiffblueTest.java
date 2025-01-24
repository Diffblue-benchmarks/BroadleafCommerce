package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.core.order.service.type.FulfillmentBandResultAmountType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mvel2.util.InternalNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
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
   * Test {@link FulfillmentWeightBandImpl#getWeightUnitOfMeasure()}.
   * <p>
   * Method under test: {@link FulfillmentWeightBandImpl#getWeightUnitOfMeasure()}
   */
  @Test
  public void testGetWeightUnitOfMeasure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl = new FulfillmentWeightBandImpl();
    fulfillmentWeightBandImpl.setMinimumWeight(mock(InternalNumber.class));

    // Act and Assert
    assertNull(fulfillmentWeightBandImpl.getWeightUnitOfMeasure());
  }

  /**
   * Test {@link FulfillmentWeightBandImpl#getWeightUnitOfMeasure()}.
   * <p>
   * Method under test: {@link FulfillmentWeightBandImpl#getWeightUnitOfMeasure()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetWeightUnitOfMeasure2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.fulfillment.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1432 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentWeightBandImpl fulfillmentWeightBandImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentWeightBandImpl()).getWeightUnitOfMeasure();
  }

  /**
   * Test {@link FulfillmentWeightBandImpl#getWeightUnitOfMeasure()}.
   * <ul>
   *   <li>Given {@link FulfillmentWeightBandImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentWeightBandImpl#getWeightUnitOfMeasure()}
   */
  @Test
  public void testGetWeightUnitOfMeasure_givenFulfillmentWeightBandImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentWeightBandImpl()).getWeightUnitOfMeasure());
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
   * <p>
   * Method under test:
   * {@link FulfillmentWeightBandImpl#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetWeightUnitOfMeasure2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.fulfillment.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1440 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentWeightBandImpl fulfillmentWeightBandImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentWeightBandImpl fulfillmentWeightBandImpl2 = new FulfillmentWeightBandImpl();

    // Act
    fulfillmentWeightBandImpl2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));
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

  /**
   * Test new {@link FulfillmentWeightBandImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FulfillmentWeightBandImpl}
   */
  @Test
  public void testNewFulfillmentWeightBandImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FulfillmentWeightBandImpl actualFulfillmentWeightBandImpl = new FulfillmentWeightBandImpl();

    // Assert
    FulfillmentBandResultAmountType resultAmountType = actualFulfillmentWeightBandImpl.getResultAmountType();
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

  /**
   * Test new {@link FulfillmentWeightBandImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FulfillmentWeightBandImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewFulfillmentWeightBandImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.fulfillment.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1431 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentWeightBandImpl fulfillmentWeightBandImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new FulfillmentWeightBandImpl();
  }
}
