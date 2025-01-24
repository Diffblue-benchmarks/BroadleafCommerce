package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.TaxService;
import org.broadleafcommerce.core.pricing.service.TaxServiceImpl;
import org.broadleafcommerce.core.pricing.service.module.TaxModule;
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
public class TaxActivityDiffblueTest {
  @Autowired
  private TaxActivity taxActivity;

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
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
    //   public class DiffblueFakeClass815 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.pricing.service.workflow.TaxActivity taxActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TaxActivity taxActivity2 = new TaxActivity();

    // Act
    taxActivity2.execute((ProcessContext<Order>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link TaxModule#calculateTaxForOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenCallsCalculateTaxForOrder() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxModule taxModule = mock(TaxModule.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(taxModule.calculateTaxForOrder(Mockito.<Order>any())).thenReturn(nullOrderImpl);

    TaxActivity taxActivity = new TaxActivity();
    taxActivity.setTaxService(null);
    taxActivity.setTaxModule(taxModule);

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(new NullOrderImpl());

    // Act
    ProcessContext<Order> actualExecuteResult = taxActivity.execute((ProcessContext<Order>) context);

    // Assert
    verify(taxModule).calculateTaxForOrder(isA(Order.class));
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(nullOrderImpl, actualExecuteResult.getSeedData());
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link TaxService#calculateTaxForOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenCallsCalculateTaxForOrder2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxService taxService = mock(TaxService.class);
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(taxService.calculateTaxForOrder(Mockito.<Order>any())).thenReturn(nullOrderImpl);

    TaxActivity taxActivity = new TaxActivity();
    taxActivity.setTaxService(taxService);
    taxActivity.setTaxModule(mock(TaxModule.class));

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(new NullOrderImpl());

    // Act
    ProcessContext<Order> actualExecuteResult = taxActivity.execute((ProcessContext<Order>) context);

    // Assert
    verify(taxService).calculateTaxForOrder(isA(Order.class));
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(nullOrderImpl, actualExecuteResult.getSeedData());
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>When {@link DefaultProcessContextImpl} (default constructor).</li>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_whenDefaultProcessContextImpl_thenReturnDefaultProcessContextImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TaxActivity taxActivity = new TaxActivity();
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, taxActivity.execute((ProcessContext<Order>) context));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaxActivity#setTaxModule(TaxModule)}
   *   <li>{@link TaxActivity#setTaxService(TaxService)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     TaxActivity.taxModule
    //     TaxActivity.taxService
    //     BaseActivity.automaticallyRegisterRollbackHandler
    //     BaseActivity.beanName
    //     BaseActivity.errorHandler
    //     BaseActivity.order
    //     BaseActivity.rollbackHandler
    //     BaseActivity.rollbackRegion
    //     BaseActivity.stateConfiguration

    // Arrange
    TaxActivity taxActivity = new TaxActivity();

    // Act
    taxActivity.setTaxModule(mock(TaxModule.class));
    taxActivity.setTaxService(new TaxServiceImpl());
  }
}
