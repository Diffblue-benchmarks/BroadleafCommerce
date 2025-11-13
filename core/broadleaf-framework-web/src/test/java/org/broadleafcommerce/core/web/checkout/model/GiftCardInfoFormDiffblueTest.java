package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GiftCardInfoFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GiftCardInfoForm}
   *   <li>{@link GiftCardInfoForm#setGiftCardEmailAddress(String)}
   *   <li>{@link GiftCardInfoForm#setGiftCardNumber(String)}
   *   <li>{@link GiftCardInfoForm#getGiftCardEmailAddress()}
   *   <li>{@link GiftCardInfoForm#getGiftCardNumber()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GiftCardInfoForm.<init>()",
    "String GiftCardInfoForm.getGiftCardEmailAddress()",
    "String GiftCardInfoForm.getGiftCardNumber()",
    "void GiftCardInfoForm.setGiftCardEmailAddress(String)",
    "void GiftCardInfoForm.setGiftCardNumber(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    GiftCardInfoForm actualGiftCardInfoForm = new GiftCardInfoForm();
    actualGiftCardInfoForm.setGiftCardEmailAddress("42 Main St");
    actualGiftCardInfoForm.setGiftCardNumber("42");
    String actualGiftCardEmailAddress = actualGiftCardInfoForm.getGiftCardEmailAddress();

    // Assert
    assertEquals("42 Main St", actualGiftCardEmailAddress);
    assertEquals("42", actualGiftCardInfoForm.getGiftCardNumber());
  }
}
