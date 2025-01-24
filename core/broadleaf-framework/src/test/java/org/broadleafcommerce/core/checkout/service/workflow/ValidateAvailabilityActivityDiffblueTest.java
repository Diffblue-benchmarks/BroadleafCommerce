package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
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
public class ValidateAvailabilityActivityDiffblueTest {
  @Autowired
  private ValidateAvailabilityActivity validateAvailabilityActivity;

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1538 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.ValidateAvailabilityActivity validateAvailabilityActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ValidateAvailabilityActivity validateAvailabilityActivity2 = new ValidateAvailabilityActivity();

    // Act
    validateAvailabilityActivity2.execute((ProcessContext<CheckoutSeed>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAvailabilityActivity validateAvailabilityActivity = new ValidateAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    checkoutSeed.setOrder(null);

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertSame(context, validateAvailabilityActivity.execute((ProcessContext<CheckoutSeed>) context));
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenReturnProcessContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAvailabilityActivity validateAvailabilityActivity = new ValidateAvailabilityActivity();
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    OrderImpl order = new OrderImpl();
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateAvailabilityActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAvailabilityActivity validateAvailabilityActivity = new ValidateAvailabilityActivity();
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    ProcessContext<CheckoutSeed> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(order).getOrderItems();
    verify(context).getSeedData();
  }
}
