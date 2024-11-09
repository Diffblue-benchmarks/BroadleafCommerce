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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class PhoneServiceImplDiffblueTest {
  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest},
   * {@code orig}.
   * <ul>
   *   <li>Then return {@link PhoneImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  public void testCopyPhoneWithDestOrig_thenReturnPhoneImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
    PhoneImpl dest = mock(PhoneImpl.class);
    doNothing().when(dest).setCountryCode(Mockito.<String>any());
    doNothing().when(dest).setExtension(Mockito.<String>any());
    doNothing().when(dest).setPhoneNumber(Mockito.<String>any());

    // Act
    Phone actualCopyPhoneResult = phoneServiceImpl.copyPhone(dest, new PhoneImpl());

    // Assert
    verify(dest).setCountryCode(isNull());
    verify(dest).setExtension(isNull());
    verify(dest).setPhoneNumber(isNull());
    assertSame(dest, actualCopyPhoneResult);
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest},
   * {@code orig}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  public void testCopyPhoneWithDestOrig_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();

    // Act and Assert
    assertNull(phoneServiceImpl.copyPhone(new PhoneImpl(), null));
  }

  /**
   * Test {@link PhoneServiceImpl#copyPhone(Phone, Phone)} with {@code dest},
   * {@code orig}.
   * <ul>
   *   <li>When {@link PhoneImpl} (default constructor).</li>
   *   <li>Then return {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneServiceImpl#copyPhone(Phone, Phone)}
   */
  @Test
  public void testCopyPhoneWithDestOrig_whenPhoneImpl_thenReturnPhoneImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
    PhoneImpl dest = new PhoneImpl();

    // Act and Assert
    assertSame(dest, phoneServiceImpl.copyPhone(dest, new PhoneImpl()));
  }
}
