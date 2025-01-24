package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftCardInfoFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GiftCardInfoForm}
   *   <li>{@link GiftCardInfoForm#setGiftCardEmailAddress(String)}
   *   <li>{@link GiftCardInfoForm#setGiftCardNumber(String)}
   *   <li>{@link GiftCardInfoForm#getGiftCardEmailAddress()}
   *   <li>{@link GiftCardInfoForm#getGiftCardNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    GiftCardInfoForm actualGiftCardInfoForm = new GiftCardInfoForm();
    actualGiftCardInfoForm.setGiftCardEmailAddress("42 Main St");
    actualGiftCardInfoForm.setGiftCardNumber("42");
    String actualGiftCardEmailAddress = actualGiftCardInfoForm.getGiftCardEmailAddress();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualGiftCardEmailAddress);
    assertEquals("42", actualGiftCardInfoForm.getGiftCardNumber());
  }
}
