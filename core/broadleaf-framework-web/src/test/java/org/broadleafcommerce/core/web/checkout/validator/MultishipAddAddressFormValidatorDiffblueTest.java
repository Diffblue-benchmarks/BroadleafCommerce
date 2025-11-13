package org.broadleafcommerce.core.web.checkout.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.web.checkout.model.ShippingInfoForm;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MultishipAddAddressFormValidatorDiffblueTest {
  /**
   * Test {@link MultishipAddAddressFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultishipAddAddressFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultishipAddAddressFormValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    MultishipAddAddressFormValidator multishipAddAddressFormValidator =
        new MultishipAddAddressFormValidator();
    Class<ShippingInfoForm> clazz = ShippingInfoForm.class;

    // Act and Assert
    assertTrue(multishipAddAddressFormValidator.supports(clazz));
  }

  /**
   * Test {@link MultishipAddAddressFormValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultishipAddAddressFormValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultishipAddAddressFormValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    MultishipAddAddressFormValidator multishipAddAddressFormValidator =
        new MultishipAddAddressFormValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(multishipAddAddressFormValidator.supports(clazz));
  }
}
