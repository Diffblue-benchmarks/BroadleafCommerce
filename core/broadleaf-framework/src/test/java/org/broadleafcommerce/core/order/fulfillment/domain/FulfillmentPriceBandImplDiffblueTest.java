package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.broadleafcommerce.core.order.service.type.FulfillmentBandResultAmountType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentPriceBandImplDiffblueTest {
  @Autowired
  private FulfillmentPriceBandImpl fulfillmentPriceBandImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentPriceBandImpl#setId(Long)}
   *   <li>{@link FulfillmentPriceBandImpl#setOption(BandedPriceFulfillmentOption)}
   *   <li>{@link FulfillmentPriceBandImpl#setRetailPriceMinimumAmount(BigDecimal)}
   *   <li>{@link FulfillmentPriceBandImpl#getId()}
   *   <li>{@link FulfillmentPriceBandImpl#getOption()}
   *   <li>{@link FulfillmentPriceBandImpl#getRetailPriceMinimumAmount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();

    // Act
    fulfillmentPriceBandImpl.setId(1L);
    BandedPriceFulfillmentOptionImpl option = new BandedPriceFulfillmentOptionImpl();
    fulfillmentPriceBandImpl.setOption(option);
    BigDecimal retailPriceMinimumAmount = new BigDecimal("2.3");
    fulfillmentPriceBandImpl.setRetailPriceMinimumAmount(retailPriceMinimumAmount);
    Long actualId = fulfillmentPriceBandImpl.getId();
    BandedPriceFulfillmentOption actualOption = fulfillmentPriceBandImpl.getOption();
    BigDecimal actualRetailPriceMinimumAmount = fulfillmentPriceBandImpl.getRetailPriceMinimumAmount();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualRetailPriceMinimumAmount);
    assertSame(retailPriceMinimumAmount, actualRetailPriceMinimumAmount);
    assertSame(option, actualOption);
  }

  /**
   * Test new {@link FulfillmentPriceBandImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FulfillmentPriceBandImpl}
   */
  @Test
  public void testNewFulfillmentPriceBandImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FulfillmentPriceBandImpl actualFulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();

    // Assert
    FulfillmentBandResultAmountType resultAmountType = actualFulfillmentPriceBandImpl.getResultAmountType();
    assertEquals("RATE", resultAmountType.getType());
    assertEquals("RATE", actualFulfillmentPriceBandImpl.resultAmountType);
    assertEquals("Rate", resultAmountType.getFriendlyType());
    assertNull(actualFulfillmentPriceBandImpl.getId());
    assertNull(actualFulfillmentPriceBandImpl.getResultAmount());
    assertNull(actualFulfillmentPriceBandImpl.getRetailPriceMinimumAmount());
    assertNull(actualFulfillmentPriceBandImpl.getOption());
  }

  /**
   * Test new {@link FulfillmentPriceBandImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FulfillmentPriceBandImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewFulfillmentPriceBandImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.fulfillment.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1430 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentPriceBandImpl fulfillmentPriceBandImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new FulfillmentPriceBandImpl();
  }
}
