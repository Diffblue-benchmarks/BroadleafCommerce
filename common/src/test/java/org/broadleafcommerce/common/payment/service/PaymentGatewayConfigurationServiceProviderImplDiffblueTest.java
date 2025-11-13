package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PaymentGatewayConfigurationServiceProviderImplDiffblueTest {
  /**
   * Test {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   *
   * <p>Method under test: {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayConfigurationService PaymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(PaymentGatewayType)"
  })
  public void testGetGatewayConfigurationService() {
    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration =
        mock(AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType())
        .thenReturn(PaymentGatewayType.PASSTHROUGH);

    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService =
        mock(AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration())
        .thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl =
        new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(
        gatewayConfigurationServices);

    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(
                gatewayType));
    verify(gatewayType).getFriendlyType();
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   *
   * <p>Method under test: {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayConfigurationService PaymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(PaymentGatewayType)"
  })
  public void testGetGatewayConfigurationService2() {
    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration =
        mock(AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType()).thenReturn(new PaymentGatewayType());

    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService =
        mock(AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration())
        .thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl =
        new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(
        gatewayConfigurationServices);

    // Act
    paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(
        mock(PaymentGatewayType.class));

    // Assert
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   *
   * <p>Method under test: {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayConfigurationService PaymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(PaymentGatewayType)"
  })
  public void testGetGatewayConfigurationService3() {
    // Arrange
    AbstractPaymentGatewayConfiguration abstractPaymentGatewayConfiguration =
        mock(AbstractPaymentGatewayConfiguration.class);
    when(abstractPaymentGatewayConfiguration.getGatewayType())
        .thenReturn(mock(PaymentGatewayType.class));

    AbstractPaymentGatewayConfigurationService abstractPaymentGatewayConfigurationService =
        mock(AbstractPaymentGatewayConfigurationService.class);
    when(abstractPaymentGatewayConfigurationService.getConfiguration())
        .thenReturn(abstractPaymentGatewayConfiguration);

    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(abstractPaymentGatewayConfigurationService);

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl =
        new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(
        gatewayConfigurationServices);

    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(
                gatewayType));
    verify(gatewayType).getFriendlyType();
    verify(abstractPaymentGatewayConfiguration).getGatewayType();
    verify(abstractPaymentGatewayConfigurationService).getConfiguration();
  }

  /**
   * Test {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   *
   * <ul>
   *   <li>Given {@code Friendly Type}.
   *   <li>Then calls {@link PaymentGatewayType#getFriendlyType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayConfigurationService PaymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(PaymentGatewayType)"
  })
  public void testGetGatewayConfigurationService_givenFriendlyType_thenCallsGetFriendlyType() {
    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl =
        new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(
        new ArrayList<>());

    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getFriendlyType()).thenReturn("Friendly Type");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(
                gatewayType));
    verify(gatewayType).getFriendlyType();
  }

  /**
   * Test {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayConfigurationService PaymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(PaymentGatewayType)"
  })
  public void testGetGatewayConfigurationService_whenNull() {
    // Arrange
    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();
    gatewayConfigurationServices.add(new AbstractPaymentGatewayConfigurationService());

    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl =
        new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(
        gatewayConfigurationServices);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(null));
  }

  /**
   * Test {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}.
   *
   * <ul>
   *   <li>When {@link PaymentGatewayType#PASSTHROUGH}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationService(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayConfigurationService PaymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(PaymentGatewayType)"
  })
  public void testGetGatewayConfigurationService_whenPassthrough() {
    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl =
        new PaymentGatewayConfigurationServiceProviderImpl();
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(
        new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationService(
                PaymentGatewayType.PASSTHROUGH));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       PaymentGatewayConfigurationServiceProviderImpl#setGatewayConfigurationServices(List)}
   *   <li>{@link PaymentGatewayConfigurationServiceProviderImpl#getGatewayConfigurationServices()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PaymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationServices()",
    "void PaymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PaymentGatewayConfigurationServiceProviderImpl paymentGatewayConfigurationServiceProviderImpl =
        new PaymentGatewayConfigurationServiceProviderImpl();
    ArrayList<PaymentGatewayConfigurationService> gatewayConfigurationServices = new ArrayList<>();

    // Act
    paymentGatewayConfigurationServiceProviderImpl.setGatewayConfigurationServices(
        gatewayConfigurationServices);
    List<PaymentGatewayConfigurationService> actualGatewayConfigurationServices =
        paymentGatewayConfigurationServiceProviderImpl.getGatewayConfigurationServices();

    // Assert
    assertTrue(actualGatewayConfigurationServices.isEmpty());
    assertSame(gatewayConfigurationServices, actualGatewayConfigurationServices);
  }
}
