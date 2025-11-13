package org.broadleafcommerce.core.checkout.service.gateway;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PassthroughPaymentConfigurationServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PassthroughPaymentConfigurationServiceImpl#getConfiguration()}
   *   <li>{@link PassthroughPaymentConfigurationServiceImpl#getTransactionService()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayConfiguration PassthroughPaymentConfigurationServiceImpl.getConfiguration()",
    "org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionService PassthroughPaymentConfigurationServiceImpl.getTransactionService()"
  })
  public void testGettersAndSetters() {
    // Arrange
    PassthroughPaymentConfigurationServiceImpl passthroughPaymentConfigurationServiceImpl =
        new PassthroughPaymentConfigurationServiceImpl();

    // Act
    PaymentGatewayConfiguration actualConfiguration =
        passthroughPaymentConfigurationServiceImpl.getConfiguration();

    // Assert
    assertNull(actualConfiguration);
    assertNull(passthroughPaymentConfigurationServiceImpl.getTransactionService());
  }
}
