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
package org.broadleafcommerce.common.web.payment.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.mockito.Mockito;

public class PaymentGatewayFieldVariableExpressionDiffblueTest {
  /**
   * Test {@link PaymentGatewayFieldVariableExpression#mapName(String)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayFieldVariableExpression#mapName(String)}
   */
  @Test
  public void testMapName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayFieldVariableExpression paymentGatewayFieldVariableExpression = new PaymentGatewayFieldVariableExpression();
    paymentGatewayFieldVariableExpression.setExtensionManager(new PaymentGatewayFieldExtensionManager());

    // Act and Assert
    assertEquals("Field Name", paymentGatewayFieldVariableExpression.mapName("Field Name"));
  }

  /**
   * Test {@link PaymentGatewayFieldVariableExpression#mapName(String)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayFieldVariableExpression#mapName(String)}
   */
  @Test
  public void testMapName_thenCallsGetProxy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayFieldExtensionHandler paymentGatewayFieldExtensionHandler = mock(
        PaymentGatewayFieldExtensionHandler.class);
    when(paymentGatewayFieldExtensionHandler.mapFieldName(Mockito.<String>any(), Mockito.<Map<String, String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    PaymentGatewayFieldExtensionManager extensionManager = mock(PaymentGatewayFieldExtensionManager.class);
    when(extensionManager.getProxy()).thenReturn(paymentGatewayFieldExtensionHandler);

    PaymentGatewayFieldVariableExpression paymentGatewayFieldVariableExpression = new PaymentGatewayFieldVariableExpression();
    paymentGatewayFieldVariableExpression.setExtensionManager(extensionManager);

    // Act
    String actualMapNameResult = paymentGatewayFieldVariableExpression.mapName("Field Name");

    // Assert
    verify(extensionManager).getProxy();
    verify(paymentGatewayFieldExtensionHandler).mapFieldName(eq("Field Name"), isA(Map.class));
    assertEquals("Field Name", actualMapNameResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PaymentGatewayFieldVariableExpression#setExtensionManager(PaymentGatewayFieldExtensionManager)}
   *   <li>{@link PaymentGatewayFieldVariableExpression#getExtensionManager()}
   *   <li>{@link PaymentGatewayFieldVariableExpression#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PaymentGatewayFieldVariableExpression paymentGatewayFieldVariableExpression = new PaymentGatewayFieldVariableExpression();
    PaymentGatewayFieldExtensionManager extensionManager = new PaymentGatewayFieldExtensionManager();

    // Act
    paymentGatewayFieldVariableExpression.setExtensionManager(extensionManager);
    PaymentGatewayFieldExtensionManager actualExtensionManager = paymentGatewayFieldVariableExpression
        .getExtensionManager();

    // Assert that nothing has changed
    assertEquals("paymentGatewayField", paymentGatewayFieldVariableExpression.getName());
    assertSame(extensionManager, actualExtensionManager);
  }
}
