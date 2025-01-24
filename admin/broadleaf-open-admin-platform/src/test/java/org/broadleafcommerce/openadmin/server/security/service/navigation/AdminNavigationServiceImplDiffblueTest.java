package org.broadleafcommerce.openadmin.server.security.service.navigation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AdminNavigationServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AdminNavigationServiceImpl#setAdditionalSectionAuthorizations(List)}
   *   <li>{@link AdminNavigationServiceImpl#getAdditionalSectionAuthorizations()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminNavigationServiceImpl adminNavigationServiceImpl = new AdminNavigationServiceImpl();
    ArrayList<SectionAuthorization> additionalSectionAuthorizations = new ArrayList<>();

    // Act
    adminNavigationServiceImpl.setAdditionalSectionAuthorizations(additionalSectionAuthorizations);
    List<SectionAuthorization> actualAdditionalSectionAuthorizations = adminNavigationServiceImpl
        .getAdditionalSectionAuthorizations();

    // Assert that nothing has changed
    assertTrue(actualAdditionalSectionAuthorizations.isEmpty());
    assertSame(additionalSectionAuthorizations, actualAdditionalSectionAuthorizations);
  }
}
