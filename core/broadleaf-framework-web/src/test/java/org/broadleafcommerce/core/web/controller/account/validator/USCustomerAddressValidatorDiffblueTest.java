package org.broadleafcommerce.core.web.controller.account.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class USCustomerAddressValidatorDiffblueTest {
  /**
   * Test {@link USCustomerAddressValidator#supports(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link USCustomerAddressValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean USCustomerAddressValidator.supports(Class)"})
  public void testSupports_thenReturnTrue() {
    // Arrange
    USCustomerAddressValidator usCustomerAddressValidator = new USCustomerAddressValidator();
    Class<CustomerAddressValidator> clazz = CustomerAddressValidator.class;

    // Act and Assert
    assertTrue(usCustomerAddressValidator.supports(clazz));
  }

  /**
   * Test {@link USCustomerAddressValidator#supports(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link USCustomerAddressValidator#supports(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean USCustomerAddressValidator.supports(Class)"})
  public void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    USCustomerAddressValidator usCustomerAddressValidator = new USCustomerAddressValidator();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(usCustomerAddressValidator.supports(clazz));
  }
}
