package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomerCreditInfoFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerCreditInfoForm}
   *   <li>{@link CustomerCreditInfoForm#setAccountNumbers(List)}
   *   <li>{@link CustomerCreditInfoForm#getAccountNumbers()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerCreditInfoForm.<init>()",
    "List CustomerCreditInfoForm.getAccountNumbers()",
    "void CustomerCreditInfoForm.setAccountNumbers(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerCreditInfoForm actualCustomerCreditInfoForm = new CustomerCreditInfoForm();
    ArrayList<String> accountNumbers = new ArrayList<>();
    actualCustomerCreditInfoForm.setAccountNumbers(accountNumbers);
    List<String> actualAccountNumbers = actualCustomerCreditInfoForm.getAccountNumbers();

    // Assert
    assertTrue(actualAccountNumbers.isEmpty());
    assertSame(accountNumbers, actualAccountNumbers);
  }
}
