package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentInfoFormValidatorDiffblueTest {
  /**
   * Test {@link PaymentInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentInfoFormValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    PaymentInfoFormValidator paymentInfoFormValidator = new PaymentInfoFormValidator();
    Class<PaymentInfoForm> clazz = PaymentInfoForm.class;

    // Act and Assert
    assertTrue(paymentInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link PaymentInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentInfoFormValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    PaymentInfoFormValidator paymentInfoFormValidator = new PaymentInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(paymentInfoFormValidator.supports(clazz));
  }
}
