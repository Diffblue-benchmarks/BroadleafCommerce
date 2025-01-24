package org.broadleafcommerce.core.order.service.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class CartOperationProcessContextFactoryDiffblueTest {
  /**
   * Test
   * {@link CartOperationProcessContextFactory#createContext(CartOperationRequest)}
   * with {@code CartOperationRequest}.
   * <p>
   * Method under test:
   * {@link CartOperationProcessContextFactory#createContext(CartOperationRequest)}
   */
  @Test
  public void testCreateContextWithCartOperationRequest() throws WorkflowException {
    // Arrange
    CartOperationProcessContextFactory cartOperationProcessContextFactory = new CartOperationProcessContextFactory();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest seedData = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    ProcessContext<CartOperationRequest> actualCreateContextResult = cartOperationProcessContextFactory
        .createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }

  /**
   * Test
   * {@link CartOperationProcessContextFactory#createContext(CartOperationRequest)}
   * with {@code CartOperationRequest}.
   * <p>
   * Method under test:
   * {@link CartOperationProcessContextFactory#createContext(CartOperationRequest)}
   */
  @Test
  public void testCreateContextWithCartOperationRequest2() throws WorkflowException {
    // Arrange
    CartOperationProcessContextFactory cartOperationProcessContextFactory = new CartOperationProcessContextFactory();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    CartOperationRequest seedData = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    ProcessContext<CartOperationRequest> actualCreateContextResult = cartOperationProcessContextFactory
        .createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }

  /**
   * Test new {@link CartOperationProcessContextFactory} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CartOperationProcessContextFactory}
   */
  @Test
  public void testNewCartOperationProcessContextFactory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new CartOperationProcessContextFactory();
  }
}
