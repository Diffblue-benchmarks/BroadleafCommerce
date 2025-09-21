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
package org.broadleafcommerce.core.checkout.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutException#CheckoutException()}
   *   <li>{@link CheckoutException#setCheckoutResponse(CheckoutResponse)}
   *   <li>{@link CheckoutException#getCheckoutResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckoutException.<init>()",
    "CheckoutResponse CheckoutException.getCheckoutResponse()",
    "void CheckoutException.setCheckoutResponse(CheckoutResponse)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CheckoutException actualCheckoutException = new CheckoutException();
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    actualCheckoutException.setCheckoutResponse(checkoutResponse);
    CheckoutResponse actualCheckoutResponse = actualCheckoutException.getCheckoutResponse();

    // Assert
    assertNull(actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getCause());
    assertNull(actualCheckoutException.getRootCause());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(checkoutResponse, actualCheckoutResponse);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutException#CheckoutException()}
   *   <li>{@link CheckoutException#setCheckoutResponse(CheckoutResponse)}
   *   <li>{@link CheckoutException#getCheckoutResponse()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckoutException.<init>()",
    "CheckoutResponse CheckoutException.getCheckoutResponse()",
    "void CheckoutException.setCheckoutResponse(CheckoutResponse)"
  })
  public void testGettersAndSetters2() {
    // Arrange and Act
    CheckoutException actualCheckoutException = new CheckoutException();
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    actualCheckoutException.setCheckoutResponse(checkoutResponse);
    CheckoutResponse actualCheckoutResponse = actualCheckoutException.getCheckoutResponse();

    // Assert
    assertNull(actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getCause());
    assertNull(actualCheckoutException.getRootCause());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(checkoutResponse, actualCheckoutResponse);
  }
}
