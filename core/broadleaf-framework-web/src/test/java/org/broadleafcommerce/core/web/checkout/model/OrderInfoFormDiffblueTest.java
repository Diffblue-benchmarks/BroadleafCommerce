package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderInfoFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderInfoForm}
   *   <li>{@link OrderInfoForm#setEmailAddress(String)}
   *   <li>{@link OrderInfoForm#getEmailAddress()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderInfoForm.<init>()",
    "String OrderInfoForm.getEmailAddress()",
    "void OrderInfoForm.setEmailAddress(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderInfoForm actualOrderInfoForm = new OrderInfoForm();
    actualOrderInfoForm.setEmailAddress("42 Main St");

    // Assert
    assertEquals("42 Main St", actualOrderInfoForm.getEmailAddress());
  }
}
