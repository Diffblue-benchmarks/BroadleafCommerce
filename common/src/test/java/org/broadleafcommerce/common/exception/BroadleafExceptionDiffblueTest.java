/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;

public class BroadleafExceptionDiffblueTest {
  /**
   * Method under test: {@link BroadleafException#getRootCause()}
   */
  @Test
  public void testGetRootCause() {
    // Arrange
    PaymentException paymentException = new PaymentException("An error occurred");

    // Act and Assert
    assertSame(paymentException, paymentException.getRootCause());
  }

  /**
   * Method under test: {@link BroadleafException#getRootCauseMessage()}
   */
  @Test
  public void testGetRootCauseMessage() {
    // Arrange, Act and Assert
    assertEquals("An error occurred", (new PaymentException("An error occurred")).getRootCauseMessage());
    assertNull((new PaymentException()).getRootCauseMessage());
  }
}
