package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConfigurationOnlyStateDiffblueTest {
  /**
   * Test {@link ConfigurationOnlyState#getState()}.
   *
   * <p>Method under test: {@link ConfigurationOnlyState#getState()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationOnlyState ConfigurationOnlyState.getState()"})
  public void testGetState() {
    // Arrange, Act and Assert
    assertFalse(ConfigurationOnlyState.getState().isConfigurationOnly());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ConfigurationOnlyState}
   *   <li>{@link ConfigurationOnlyState#setConfigurationOnly(boolean)}
   *   <li>{@link ConfigurationOnlyState#isConfigurationOnly()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConfigurationOnlyState.<init>()",
    "boolean ConfigurationOnlyState.isConfigurationOnly()",
    "void ConfigurationOnlyState.setConfigurationOnly(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ConfigurationOnlyState actualConfigurationOnlyState = new ConfigurationOnlyState();
    actualConfigurationOnlyState.setConfigurationOnly(true);

    // Assert
    assertTrue(actualConfigurationOnlyState.isConfigurationOnly());
  }
}
