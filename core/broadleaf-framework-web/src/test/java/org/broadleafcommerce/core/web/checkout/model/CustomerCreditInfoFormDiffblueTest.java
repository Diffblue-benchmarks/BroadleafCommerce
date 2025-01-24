package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerCreditInfoFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerCreditInfoForm}
   *   <li>{@link CustomerCreditInfoForm#setAccountNumbers(List)}
   *   <li>{@link CustomerCreditInfoForm#getAccountNumbers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CustomerCreditInfoForm actualCustomerCreditInfoForm = new CustomerCreditInfoForm();
    ArrayList<String> accountNumbers = new ArrayList<>();
    actualCustomerCreditInfoForm.setAccountNumbers(accountNumbers);
    List<String> actualAccountNumbers = actualCustomerCreditInfoForm.getAccountNumbers();

    // Assert that nothing has changed
    assertTrue(actualAccountNumbers.isEmpty());
    assertSame(accountNumbers, actualAccountNumbers);
  }
}
