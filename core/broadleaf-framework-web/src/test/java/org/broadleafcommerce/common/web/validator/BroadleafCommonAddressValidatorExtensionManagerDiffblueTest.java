package org.broadleafcommerce.common.web.validator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BroadleafCommonAddressValidatorExtensionManager.class})
@ExtendWith(SpringExtension.class)
class BroadleafCommonAddressValidatorExtensionManagerDiffblueTest {
  @Autowired
  private BroadleafCommonAddressValidatorExtensionManager broadleafCommonAddressValidatorExtensionManager;

  /**
   * Test
   * {@link BroadleafCommonAddressValidatorExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link BroadleafCommonAddressValidatorExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled()")
  void testContinueOnHandled() {
    // Arrange, Act and Assert
    assertTrue(broadleafCommonAddressValidatorExtensionManager.continueOnHandled());
  }
}
