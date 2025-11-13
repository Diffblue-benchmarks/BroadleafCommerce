package org.broadleafcommerce.openadmin.web.rulebuilder.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RuleBuilderEnumOptionsExtensionManagerDiffblueTest {
  /**
   * Test {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleBuilderEnumOptionsExtensionManager.getOptionValues()"})
  public void testGetOptionValues_thenReturn42() {
    // Arrange
    RuleBuilderEnumOptionsExtensionListener ruleBuilderEnumOptionsExtensionListener =
        mock(RuleBuilderEnumOptionsExtensionListener.class);
    when(ruleBuilderEnumOptionsExtensionListener.getOptionValues()).thenReturn("42");

    ArrayList<RuleBuilderEnumOptionsExtensionListener> listeners = new ArrayList<>();
    listeners.add(ruleBuilderEnumOptionsExtensionListener);

    RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager =
        new RuleBuilderEnumOptionsExtensionManager();
    ruleBuilderEnumOptionsExtensionManager.setListeners(listeners);

    // Act
    String actualOptionValues = ruleBuilderEnumOptionsExtensionManager.getOptionValues();

    // Assert
    verify(ruleBuilderEnumOptionsExtensionListener).getOptionValues();
    assertEquals("42\r\n", actualOptionValues);
  }

  /**
   * Test {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleBuilderEnumOptionsExtensionManager.getOptionValues()"})
  public void testGetOptionValues_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new RuleBuilderEnumOptionsExtensionManager().getOptionValues());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleBuilderEnumOptionsExtensionManager#setListeners(List)}
   *   <li>{@link RuleBuilderEnumOptionsExtensionManager#getListeners()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RuleBuilderEnumOptionsExtensionManager.getListeners()",
    "void RuleBuilderEnumOptionsExtensionManager.setListeners(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager =
        new RuleBuilderEnumOptionsExtensionManager();
    ArrayList<RuleBuilderEnumOptionsExtensionListener> listeners = new ArrayList<>();

    // Act
    ruleBuilderEnumOptionsExtensionManager.setListeners(listeners);
    List<RuleBuilderEnumOptionsExtensionListener> actualListeners =
        ruleBuilderEnumOptionsExtensionManager.getListeners();

    // Assert
    assertTrue(actualListeners.isEmpty());
    assertSame(listeners, actualListeners);
  }
}
