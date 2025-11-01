/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.service.exception.AddressVerificationException;
import org.junit.Test;

public class AddressServiceImplDiffblueTest {
  /**
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress() throws AddressVerificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    AddressImpl address = new AddressImpl();

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress2() throws AddressVerificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getStandardized()).thenReturn(true);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(address, atLeast(1)).getStandardized();
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress3() throws AddressVerificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getStandardized()).thenReturn(null);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(address).getStandardized();
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress4() throws AddressVerificationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    addressServiceImpl.setMustValidateAddresses(true);
    AddressImpl address = mock(AddressImpl.class);
    when(address.getStandardized()).thenReturn(null);

    // Act and Assert
    assertThrows(AddressVerificationException.class, () -> addressServiceImpl.verifyAddress(address));
    verify(address).getStandardized();
  }

  /**
   * Method under test: {@link AddressServiceImpl#copyAddress(Address, Address)}
   */
  @Test
  public void testCopyAddress() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();

    // Act and Assert
    assertNull(addressServiceImpl.copyAddress(new AddressImpl(), null));
  }

  /**
   * Method under test:
   * {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  public void testPopulateAddressISOCountrySub() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    AddressImpl address = mock(AddressImpl.class);
    when(address.getIsoCountrySubdivision()).thenReturn("GB");

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert
    verify(address).getIsoCountrySubdivision();
  }
}
