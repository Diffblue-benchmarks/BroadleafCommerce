package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractCustomerAddressControllerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AbstractCustomerAddressController}
   *   <li>{@link AbstractCustomerAddressController#getCustomerAddressesRedirect()}
   *   <li>{@link AbstractCustomerAddressController#getCustomerAddressesView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCustomerAddressController.<init>()",
    "String AbstractCustomerAddressController.getCustomerAddressesRedirect()",
    "String AbstractCustomerAddressController.getCustomerAddressesView()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AbstractCustomerAddressController actualAbstractCustomerAddressController =
        new AbstractCustomerAddressController();
    String actualCustomerAddressesRedirect =
        actualAbstractCustomerAddressController.getCustomerAddressesRedirect();

    // Assert
    assertEquals(
        "account/manageCustomerAddresses",
        actualAbstractCustomerAddressController.getCustomerAddressesView());
    assertEquals("redirect:/account/addresses", actualCustomerAddressesRedirect);
  }
}
