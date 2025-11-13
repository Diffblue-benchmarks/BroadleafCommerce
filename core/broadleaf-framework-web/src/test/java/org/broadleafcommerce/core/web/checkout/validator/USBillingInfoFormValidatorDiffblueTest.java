package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.BillingInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class USBillingInfoFormValidatorDiffblueTest {
  /**
   * Test {@link USBillingInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link USBillingInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean USBillingInfoFormValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    USBillingInfoFormValidator usBillingInfoFormValidator = new USBillingInfoFormValidator();
    Class<BillingInfoForm> clazz = BillingInfoForm.class;

    // Act and Assert
    assertTrue(usBillingInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link USBillingInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link USBillingInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean USBillingInfoFormValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    USBillingInfoFormValidator usBillingInfoFormValidator = new USBillingInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(usBillingInfoFormValidator.supports(clazz));
  }
}
