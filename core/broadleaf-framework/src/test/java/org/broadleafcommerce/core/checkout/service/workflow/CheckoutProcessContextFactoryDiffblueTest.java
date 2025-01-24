package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.junit.Test;

public class CheckoutProcessContextFactoryDiffblueTest {
  /**
   * Test {@link CheckoutProcessContextFactory#createContext(CheckoutSeed)} with
   * {@code CheckoutSeed}.
   * <p>
   * Method under test:
   * {@link CheckoutProcessContextFactory#createContext(CheckoutSeed)}
   */
  @Test
  public void testCreateContextWithCheckoutSeed() throws WorkflowException {
    // Arrange
    CheckoutProcessContextFactory checkoutProcessContextFactory = new CheckoutProcessContextFactory();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seedData = new CheckoutSeed(order, new HashMap<>());

    // Act
    ProcessContext<CheckoutSeed> actualCreateContextResult = checkoutProcessContextFactory.createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertFalse(actualCreateContextResult.isStopped());
    assertTrue(((DefaultProcessContextImpl<CheckoutSeed>) actualCreateContextResult).getActivityMessages().isEmpty());
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }

  /**
   * Test {@link CheckoutProcessContextFactory#createContext(CheckoutSeed)} with
   * {@code CheckoutSeed}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CheckoutProcessContextFactory#createContext(CheckoutSeed)}
   */
  @Test
  public void testCreateContextWithCheckoutSeed_givenFoo() throws WorkflowException {
    // Arrange
    CheckoutProcessContextFactory checkoutProcessContextFactory = new CheckoutProcessContextFactory();

    HashMap<String, Object> userDefinedFields = new HashMap<>();
    userDefinedFields.computeIfPresent("foo", mock(BiFunction.class));
    CheckoutSeed seedData = new CheckoutSeed(new NullOrderImpl(), userDefinedFields);

    // Act
    ProcessContext<CheckoutSeed> actualCreateContextResult = checkoutProcessContextFactory.createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertFalse(actualCreateContextResult.isStopped());
    assertTrue(((DefaultProcessContextImpl<CheckoutSeed>) actualCreateContextResult).getActivityMessages().isEmpty());
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }

  /**
   * Test new {@link CheckoutProcessContextFactory} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CheckoutProcessContextFactory}
   */
  @Test
  public void testNewCheckoutProcessContextFactory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new CheckoutProcessContextFactory();
  }
}
