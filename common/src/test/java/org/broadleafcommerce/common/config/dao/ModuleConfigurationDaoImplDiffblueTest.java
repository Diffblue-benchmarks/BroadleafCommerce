package org.broadleafcommerce.common.config.dao;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModuleConfigurationDaoImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConfigurationDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link ModuleConfigurationDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ModuleConfigurationDaoImpl.getCurrentDateResolution()",
    "void ModuleConfigurationDaoImpl.setCurrentDateResolution(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ModuleConfigurationDaoImpl moduleConfigurationDaoImpl = new ModuleConfigurationDaoImpl();

    // Act
    moduleConfigurationDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, moduleConfigurationDaoImpl.getCurrentDateResolution().longValue());
  }
}
