package org.broadleafcommerce.profile.web.controller.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomerPhoneValidatorDiffblueTest {
  /**
   * Test {@link CustomerPhoneValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerPhoneValidator.supports(Class)"})
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CustomerPhoneValidator customerPhoneValidator = new CustomerPhoneValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(customerPhoneValidator.supports(clazz));
  }

  /**
   * Test {@link CustomerPhoneValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Phone}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPhoneValidator#supports(Class)}
   */
  @Test
  @DisplayName(
      "Test supports(Class); when 'org.broadleafcommerce.profile.core.domain.Phone'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerPhoneValidator.supports(Class)"})
  void testSupports_whenOrgBroadleafcommerceProfileCoreDomainPhone_thenReturnTrue() {
    // Arrange
    CustomerPhoneValidator customerPhoneValidator = new CustomerPhoneValidator();
    Class<Phone> clazz = Phone.class;

    // Act and Assert
    assertTrue(customerPhoneValidator.supports(clazz));
  }
}
