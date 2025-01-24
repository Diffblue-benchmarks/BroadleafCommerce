package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
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
public class FulfillmentBandImplDiffblueTest {
  @Autowired
  private FulfillmentBandImpl fulfillmentBandImpl;

  /**
   * Test {@link FulfillmentBandImpl#getResultAmount()}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmount()}
   */
  @Test
  public void testGetResultAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    fulfillmentPriceBandImpl.setRetailPriceMinimumAmount(mock(InternalNumber.class));

    // Act and Assert
    assertNull(fulfillmentPriceBandImpl.getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#getResultAmount()}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmount()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetResultAmount2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.fulfillment.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1392 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentBandImpl fulfillmentBandImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    fulfillmentBandImpl.getResultAmount();
  }

  /**
   * Test {@link FulfillmentBandImpl#getResultAmount()}.
   * <ul>
   *   <li>Given {@link FulfillmentPriceBandImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmount()}
   */
  @Test
  public void testGetResultAmount_givenFulfillmentPriceBandImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentPriceBandImpl()).getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetResultAmount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.fulfillment.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1394 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentBandImpl fulfillmentBandImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    fulfillmentBandImpl.setResultAmount(new BigDecimal("2.3"));
  }

  /**
   * Test {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}.
   * <ul>
   *   <li>Then {@link FulfillmentPriceBandImpl} (default constructor) ResultAmount
   * is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}
   */
  @Test
  public void testSetResultAmount_thenFulfillmentPriceBandImplResultAmountIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    BigDecimal resultAmount = new BigDecimal("2.3");

    // Act
    fulfillmentPriceBandImpl.setResultAmount(resultAmount);

    // Assert
    assertSame(resultAmount, fulfillmentPriceBandImpl.getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}.
   * <ul>
   *   <li>Then {@link FulfillmentPriceBandImpl} (default constructor) ResultAmount
   * is {@link InternalNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#setResultAmount(BigDecimal)}
   */
  @Test
  public void testSetResultAmount_thenFulfillmentPriceBandImplResultAmountIsInternalNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    InternalNumber resultAmount = mock(InternalNumber.class);

    // Act
    fulfillmentPriceBandImpl.setResultAmount(resultAmount);

    // Assert
    assertSame(resultAmount, fulfillmentPriceBandImpl.getResultAmount());
  }

  /**
   * Test {@link FulfillmentBandImpl#getResultAmountType()}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmountType()}
   */
  @Test
  public void testGetResultAmountType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    fulfillmentPriceBandImpl.setRetailPriceMinimumAmount(mock(InternalNumber.class));

    // Act
    FulfillmentBandResultAmountType actualResultAmountType = fulfillmentPriceBandImpl.getResultAmountType();

    // Assert
    assertSame(actualResultAmountType.RATE, actualResultAmountType);
  }

  /**
   * Test {@link FulfillmentBandImpl#getResultAmountType()}.
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmountType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetResultAmountType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.fulfillment.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1393 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentBandImpl fulfillmentBandImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    fulfillmentBandImpl.getResultAmountType();
  }

  /**
   * Test {@link FulfillmentBandImpl#getResultAmountType()}.
   * <ul>
   *   <li>Given {@link FulfillmentPriceBandImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandImpl#getResultAmountType()}
   */
  @Test
  public void testGetResultAmountType_givenFulfillmentPriceBandImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FulfillmentBandResultAmountType actualResultAmountType = (new FulfillmentPriceBandImpl()).getResultAmountType();

    // Assert
    assertSame(actualResultAmountType.RATE, actualResultAmountType);
  }

  /**
   * Test
   * {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}.
   * <p>
   * Method under test:
   * {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}
   */
  @Test
  public void testSetResultAmountType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    FulfillmentBandResultAmountType resultAmountType = mock(FulfillmentBandResultAmountType.class);
    when(resultAmountType.getType()).thenReturn("Type");

    // Act
    fulfillmentPriceBandImpl.setResultAmountType(resultAmountType);

    // Assert
    verify(resultAmountType).getType();
    FulfillmentBandResultAmountType resultAmountType2 = fulfillmentPriceBandImpl.getResultAmountType();
    assertEquals("Friendly Type", resultAmountType2.getFriendlyType());
    assertEquals("Type", resultAmountType2.getType());
    assertEquals("Type", fulfillmentPriceBandImpl.resultAmountType);
  }

  /**
   * Test
   * {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}.
   * <p>
   * Method under test:
   * {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetResultAmountType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.fulfillment.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1424 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentBandImpl fulfillmentBandImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    fulfillmentBandImpl.setResultAmountType(FulfillmentBandResultAmountType.PERCENTAGE);
  }

  /**
   * Test
   * {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}.
   * <ul>
   *   <li>Then {@link FulfillmentPriceBandImpl} (default constructor)
   * {@link FulfillmentBandImpl#resultAmountType} is {@code PERCENTAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentBandImpl#setResultAmountType(FulfillmentBandResultAmountType)}
   */
  @Test
  public void testSetResultAmountType_thenFulfillmentPriceBandImplResultAmountTypeIsPercentage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();
    FulfillmentBandResultAmountType resultAmountType = FulfillmentBandResultAmountType.PERCENTAGE;

    // Act
    fulfillmentPriceBandImpl.setResultAmountType(resultAmountType);

    // Assert
    assertEquals("PERCENTAGE", fulfillmentPriceBandImpl.resultAmountType);
    FulfillmentBandResultAmountType expectedResultAmountType = resultAmountType.PERCENTAGE;
    assertSame(expectedResultAmountType, fulfillmentPriceBandImpl.getResultAmountType());
  }
}
