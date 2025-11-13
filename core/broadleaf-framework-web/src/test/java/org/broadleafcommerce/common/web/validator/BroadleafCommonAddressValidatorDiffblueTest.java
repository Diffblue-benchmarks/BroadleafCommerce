package org.broadleafcommerce.common.web.validator;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafCommonAddressValidatorDiffblueTest {
  /**
   * Test new {@link BroadleafCommonAddressValidator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafCommonAddressValidator}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCommonAddressValidator.<init>()"})
  public void testNewBroadleafCommonAddressValidator() {
    // Arrange, Act and Assert
    assertNull(new BroadleafCommonAddressValidator().validatorExtensionManager);
  }
}
