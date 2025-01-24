package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RowLevelSecurityServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RowLevelSecurityServiceImpl#setProviders(List)}
   *   <li>{@link RowLevelSecurityServiceImpl#getProviders()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();

    // Act
    rowLevelSecurityServiceImpl.setProviders(providers);
    List<RowLevelSecurityProvider> actualProviders = rowLevelSecurityServiceImpl.getProviders();

    // Assert that nothing has changed
    assertTrue(actualProviders.isEmpty());
    assertSame(providers, actualProviders);
  }
}
