package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.pricing.service.TaxService;
import org.broadleafcommerce.core.pricing.service.module.TaxModule;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TaxActivityDiffblueTest {
  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link TaxActivity} (default constructor) TaxService is {@code null}.
   *   <li>Then calls {@link TaxModule#calculateTaxForOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext TaxActivity.execute(ProcessContext)"})
  public void testExecute_givenTaxActivityTaxServiceIsNull_thenCallsCalculateTaxForOrder()
      throws Exception {
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
    ProcessContext<Order> actualExecuteResult = taxActivity.execute(context);

    // Assert
    verify(taxModule).calculateTaxForOrder(isA(Order.class));
    Order seedData = actualExecuteResult.getSeedData();
    assertTrue(seedData instanceof NullOrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(nullOrderImpl, seedData);
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link TaxActivity} (default constructor) TaxService is {@link TaxService}.
   *   <li>Then calls {@link TaxService#calculateTaxForOrder(Order)}.
   * </ul>
   *
   * <p>Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext TaxActivity.execute(ProcessContext)"})
  public void testExecute_givenTaxActivityTaxServiceIsTaxService_thenCallsCalculateTaxForOrder()
      throws Exception {
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
    ProcessContext<Order> actualExecuteResult = taxActivity.execute(context);

    // Assert
    verify(taxService).calculateTaxForOrder(isA(Order.class));
    Order seedData = actualExecuteResult.getSeedData();
    assertTrue(seedData instanceof NullOrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(nullOrderImpl, seedData);
  }

  /**
   * Test {@link TaxActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link TaxActivity} (default constructor).
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TaxActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext TaxActivity.execute(ProcessContext)"})
  public void testExecute_givenTaxActivity_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    TaxActivity taxActivity = new TaxActivity();
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<Order> actualExecuteResult = taxActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }
}
