/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
