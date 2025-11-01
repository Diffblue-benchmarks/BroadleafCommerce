/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Test;

class CustomerStateRefresherDiffblueTest {
  /**
   * Method under test:
   * {@link CustomerStateRefresher#resetTransientFields(Customer, Customer)}
   */
  @Test
  void testResetTransientFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRefresher customerStateRefresher = new CustomerStateRefresher();
    CustomerImpl preMergedCustomer = new CustomerImpl();

    // Act
    customerStateRefresher.resetTransientFields(preMergedCustomer, new CustomerImpl());

    // Assert
    assertNull(preMergedCustomer.getUnencodedChallengeAnswer());
    assertNull(preMergedCustomer.getUnencodedPassword());
    assertFalse(preMergedCustomer.isLoggedIn());
  }

  /**
   * Method under test:
   * {@link CustomerStateRefresher#resetTransientFields(Customer, Customer)}
   */
  @Test
  void testResetTransientFields2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerStateRefresher customerStateRefresher = new CustomerStateRefresher();
    CustomerImpl preMergedCustomer = mock(CustomerImpl.class);
    when(preMergedCustomer.isAnonymous()).thenReturn(true);
    when(preMergedCustomer.isCookied()).thenReturn(true);
    when(preMergedCustomer.isRegistered()).thenReturn(true);
    when(preMergedCustomer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(preMergedCustomer.getUnencodedPassword()).thenReturn("secret");
    when(preMergedCustomer.getTransientProperties()).thenReturn(new HashMap<>());
    CustomerImpl postMergedCustomer = new CustomerImpl();

    // Act
    customerStateRefresher.resetTransientFields(preMergedCustomer, postMergedCustomer);

    // Assert
    verify(preMergedCustomer).getTransientProperties();
    verify(preMergedCustomer).getUnencodedChallengeAnswer();
    verify(preMergedCustomer).getUnencodedPassword();
    verify(preMergedCustomer).isAnonymous();
    verify(preMergedCustomer).isCookied();
    verify(preMergedCustomer).isRegistered();
    assertEquals("secret", postMergedCustomer.getUnencodedChallengeAnswer());
    assertEquals("secret", postMergedCustomer.getUnencodedPassword());
    assertTrue(postMergedCustomer.isLoggedIn());
  }
}
