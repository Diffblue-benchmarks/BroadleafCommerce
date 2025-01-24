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
