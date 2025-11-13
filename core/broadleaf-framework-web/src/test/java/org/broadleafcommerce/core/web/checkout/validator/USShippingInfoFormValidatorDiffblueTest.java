package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class USShippingInfoFormValidatorDiffblueTest {
  /**
   * Test {@link USShippingInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link USShippingInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean USShippingInfoFormValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    USShippingInfoFormValidator usShippingInfoFormValidator = new USShippingInfoFormValidator();
    Class<ShippingInfoForm> clazz = ShippingInfoForm.class;

    // Act and Assert
    assertTrue(usShippingInfoFormValidator.supports(clazz));
  }

  /**
   * Test {@link USShippingInfoFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link USShippingInfoFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean USShippingInfoFormValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    USShippingInfoFormValidator usShippingInfoFormValidator = new USShippingInfoFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(usShippingInfoFormValidator.supports(clazz));
  }
}
