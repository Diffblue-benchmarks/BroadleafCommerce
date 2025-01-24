package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.FulfillmentPricingService;
import org.broadleafcommerce.core.pricing.service.FulfillmentPricingServiceImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentGroupPricingActivityDiffblueTest {
  @Autowired
  private FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity;

  /**
   * Test
   * {@link FulfillmentGroupPricingActivity#setFulfillmentPricingService(FulfillmentPricingService)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#setFulfillmentPricingService(FulfillmentPricingService)}
   */
  @Test
  public void testSetFulfillmentPricingService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     FulfillmentGroupPricingActivity.fulfillmentPricingService
    //     BaseActivity.automaticallyRegisterRollbackHandler
    //     BaseActivity.beanName
    //     BaseActivity.errorHandler
    //     BaseActivity.order
    //     BaseActivity.rollbackHandler
    //     BaseActivity.rollbackRegion
    //     BaseActivity.stateConfiguration

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();

    // Act
    fulfillmentGroupPricingActivity.setFulfillmentPricingService(new FulfillmentPricingServiceImpl());
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.pricing.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass106 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.workflow.FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity2 = new FulfillmentGroupPricingActivity();

    // Act
    fulfillmentGroupPricingActivity2.execute((ProcessContext<Order>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenArrayListAddNull_thenReturnProcessContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(null);
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}
   * {@link FulfillmentGroupImpl#getFulfillmentPrice()} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenFulfillmentGroupImplGetFulfillmentPriceReturnMoney() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(new Money());
    when(fulfillmentGroupImpl.getShippingOverride()).thenReturn(true);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(fulfillmentGroupImpl, atLeast(1)).getFulfillmentPrice();
    verify(fulfillmentGroupImpl).getShippingOverride();
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}
   * {@link FulfillmentGroupImpl#getFulfillmentPrice()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenFulfillmentGroupImplGetFulfillmentPriceReturnNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(null);
    when(fulfillmentGroupImpl.getShippingOverride()).thenReturn(true);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(fulfillmentGroupImpl).getFulfillmentPrice();
    verify(fulfillmentGroupImpl).getShippingOverride();
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getCurrency()} return
   * {@code null}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupPricingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenNullOrderImplGetCurrencyReturnNull_thenReturnProcessContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupPricingActivity fulfillmentGroupPricingActivity = new FulfillmentGroupPricingActivity();
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    doNothing().when(nullOrderImpl).setTotalFulfillmentCharges(Mockito.<Money>any());
    ProcessContext<Order> context = mock(ProcessContext.class);
    doNothing().when(context).setSeedData(Mockito.<Order>any());
    when(context.getSeedData()).thenReturn(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentGroupPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl).getCurrency();
    verify(nullOrderImpl).getFulfillmentGroups();
    verify(nullOrderImpl).setTotalFulfillmentCharges(isA(Money.class));
    verify(context).getSeedData();
    verify(context).setSeedData(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }
}
