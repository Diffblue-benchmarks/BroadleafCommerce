/*-
 * #%L
 * BroadleafCommerce Profile Web
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
