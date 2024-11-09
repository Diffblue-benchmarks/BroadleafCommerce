/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.junit.Test;

public class PaymentGatewayConfigurationServiceProviderImplDiffblueTest {
  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration = mock(
        AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType()).thenReturn(PaymentGatewayType.PASSTHROUGH);
    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService = mock(
        AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration()).thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(gatewayConfigurationServices);
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(gatewayType));
    verify(gatewayType).getFriendlyType();
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration = mock(
        AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType()).thenReturn(new PaymentGatewayType());
    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService = mock(
        AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration()).thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(gatewayConfigurationServices);

    // Act
    paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(mock(PaymentGatewayType.class));

    // Assert
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration = mock(
        AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType()).thenReturn(mock(PaymentGatewayType.class));
    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService = mock(
        AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration()).thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(gatewayConfigurationServices);
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(gatewayType));
    verify(gatewayType).getFriendlyType();
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <ul>
   *   <li>Given {@code Friendly Type}.</li>
   *   <li>Then calls {@link PaymentGatewayType#getFriendlyType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService_givenFriendlyType_thenCallsGetFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(new ArrayList<>());
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(gatewayType));
    verify(gatewayType).getFriendlyType();
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PaymentGatewayConfigurationServiceProviderImpl()).getGatewayConfigurationService(null));
  }

  /**
   * Test
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   * <ul>
   *   <li>When {@link PaymentGatewayType#PASSTHROUGH}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  public void testGetGatewayConfigurationService_whenPassthrough() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> paymentGatewayConfigurationServiceProviderImpl
        .getGatewayConfigurationService(PaymentGatewayType.PASSTHROUGH));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PaymentGatewayConfigurationServiceProviderImpl#setGatewayConfigurationServices(List)}
   *   <li>
   * {@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationServices()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl = new PaymentGatewayConfigurationServiceProviderImpl();
    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();

    // Act
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(gatewayConfigurationServices);
    List<PaymentGatewayConfigurationService> actualGatewayConfigurationServices = paymentGatewayConfigurationServiceProviderImpl
        .getGatewayConfigurationServices();

    // Assert that nothing has changed
    assertTrue(actualGatewayConfigurationServices.isEmpty());
    assertSame(gatewayConfigurationServices, actualGatewayConfigurationServices);
  }
}
