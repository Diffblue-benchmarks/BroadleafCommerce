/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PhoneNameFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PhoneNameForm}
   *   <li>{@link PhoneNameForm#setPhone(Phone)}
   *   <li>{@link PhoneNameForm#setPhoneName(String)}
   *   <li>{@link PhoneNameForm#getPhone()}
   *   <li>{@link PhoneNameForm#getPhoneName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    PhoneNameForm actualPhoneNameForm = new PhoneNameForm();
    PhoneImpl phone = new PhoneImpl();
    actualPhoneNameForm.setPhone(phone);
    actualPhoneNameForm.setPhoneName("6625550144");
    Phone actualPhone = actualPhoneNameForm.getPhone();

    // Assert that nothing has changed
    assertEquals("6625550144", actualPhoneNameForm.getPhoneName());
    assertSame(phone, actualPhone);
  }
}
