package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EmptyFilterValuesDiffblueTest {
  /**
   * Test new {@link EmptyFilterValues} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link EmptyFilterValues}
   */
  @Test
  public void testNewEmptyFilterValues() {
    // Arrange, Act and Assert
    assertTrue((new EmptyFilterValues()).isEmpty());
  }
}
