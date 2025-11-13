package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.GiftCardInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

public class GiftCardInfoFormValidatorDiffblueTest {
  /**
   * Test {@link GiftCardInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GiftCardInfoFormValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    GiftCardInfoFormValidator giftCardInfoFormValidator = new GiftCardInfoFormValidator();
    Class<GiftCardInfoForm> clazz = GiftCardInfoForm.class;

    // Act and Assert
    assertTrue(giftCardInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link GiftCardInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GiftCardInfoFormValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    GiftCardInfoFormValidator giftCardInfoFormValidator = new GiftCardInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(giftCardInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link GiftCardInfoFormValidator#validate(Object, Errors)}.
   *
   * <p>Method under test: {@link GiftCardInfoFormValidator#validate(Object, Errors)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GiftCardInfoFormValidator.validate(Object, Errors)"})
  public void testValidate() {
    // Arrange
    GiftCardInfoFormValidator giftCardInfoFormValidator = new GiftCardInfoFormValidator();

    GiftCardInfoForm giftCardInfoForm = new GiftCardInfoForm();
    giftCardInfoForm.setGiftCardEmailAddress("42 Main St");
    giftCardInfoForm.setGiftCardNumber("42");
    BindException errors =
        new BindException(
            giftCardInfoForm, "org.broadleafcommerce.core.web.checkout.model.GiftCardInfoForm");

    // Act and Assert
    giftCardInfoFormValidator.validate(giftCardInfoForm, errors);
  }
}
