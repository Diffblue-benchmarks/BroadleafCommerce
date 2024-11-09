/*-
 * #%L
 * BroadleafCommerce Profile
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
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return first is {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress_givenNull_thenReturnFirstIsAddressImpl() throws AddressVerificationException {
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
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link AddressImpl} {@link AddressImpl#getStandardized()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress_givenTrue_whenAddressImplGetStandardizedReturnTrue()
      throws AddressVerificationException {
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
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <ul>
   *   <li>Then throw {@link AddressVerificationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress_thenThrowAddressVerificationException() throws AddressVerificationException {
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
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).</li>
   *   <li>Then return first is {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  public void testVerifyAddress_whenAddressImpl_thenReturnFirstIsAddressImpl() throws AddressVerificationException {
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
   * Test {@link AddressServiceImpl#copyAddress(Address, Address)} with
   * {@code dest}, {@code orig}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddressServiceImpl#copyAddress(Address, Address)}
   */
  @Test
  public void testCopyAddressWithDestOrig_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();

    // Act and Assert
    assertNull(addressServiceImpl.copyAddress(new AddressImpl(), null));
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   * <ul>
   *   <li>Given {@code GB}.</li>
   *   <li>Then calls {@link AddressImpl#getIsoCountrySubdivision()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  public void testPopulateAddressISOCountrySub_givenGb_thenCallsGetIsoCountrySubdivision() {
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
