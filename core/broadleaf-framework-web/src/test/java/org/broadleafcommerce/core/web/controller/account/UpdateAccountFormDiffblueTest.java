package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UpdateAccountFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UpdateAccountForm}
   *   <li>{@link UpdateAccountForm#setEmailAddress(String)}
   *   <li>{@link UpdateAccountForm#setFirstName(String)}
   *   <li>{@link UpdateAccountForm#setLastName(String)}
   *   <li>{@link UpdateAccountForm#getEmailAddress()}
   *   <li>{@link UpdateAccountForm#getFirstName()}
   *   <li>{@link UpdateAccountForm#getLastName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpdateAccountForm.<init>()",
    "String UpdateAccountForm.getEmailAddress()",
    "String UpdateAccountForm.getFirstName()",
    "String UpdateAccountForm.getLastName()",
    "void UpdateAccountForm.setEmailAddress(String)",
    "void UpdateAccountForm.setFirstName(String)",
    "void UpdateAccountForm.setLastName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UpdateAccountForm actualUpdateAccountForm = new UpdateAccountForm();
    actualUpdateAccountForm.setEmailAddress("42 Main St");
    actualUpdateAccountForm.setFirstName("Jane");
    actualUpdateAccountForm.setLastName("Doe");
    String actualEmailAddress = actualUpdateAccountForm.getEmailAddress();
    String actualFirstName = actualUpdateAccountForm.getFirstName();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("Doe", actualUpdateAccountForm.getLastName());
    assertEquals("Jane", actualFirstName);
  }
}
