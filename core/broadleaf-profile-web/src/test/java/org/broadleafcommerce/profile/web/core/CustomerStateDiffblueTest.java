package org.broadleafcommerce.profile.web.core;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomerStateDiffblueTest {
  /**
   * Test {@link CustomerState#getCustomer()}.
   *
   * <p>Method under test: {@link CustomerState#getCustomer()}
   */
  @Test
  @DisplayName("Test getCustomer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.profile.core.domain.Customer CustomerState.getCustomer()"
  })
  void testGetCustomer() {
    // Arrange, Act and Assert
    assertNull(CustomerState.getCustomer());
  }
}
