package org.broadleafcommerce.common.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StaleStateProtectionServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StaleStateProtectionServiceImpl#getStateVersionTokenParameter()}
   *   <li>{@link StaleStateProtectionServiceImpl#isEnabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaleStateProtectionServiceImpl.getStateVersionTokenParameter()",
    "boolean StaleStateProtectionServiceImpl.isEnabled()"
  })
  public void testGettersAndSetters() {
    // Arrange
    StaleStateProtectionServiceImpl staleStateProtectionServiceImpl =
        new StaleStateProtectionServiceImpl();

    // Act
    String actualStateVersionTokenParameter =
        staleStateProtectionServiceImpl.getStateVersionTokenParameter();

    // Assert
    assertFalse(staleStateProtectionServiceImpl.isEnabled());
    assertEquals(
        StaleStateProtectionServiceImpl.STATEVERSIONTOKEN, actualStateVersionTokenParameter);
  }
}
