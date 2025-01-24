package org.broadleafcommerce.openadmin.web.rulebuilder.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleBuilderEnumOptionsExtensionManagerDiffblueTest {
  @Autowired
  private RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager;

  /**
   * Test {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}.
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOptionValues() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.rulebuilder.enums;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.rulebuilder.enums.RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RuleBuilderEnumOptionsExtensionManager()).getOptionValues();
  }

  /**
   * Test {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}
   */
  @Test
  public void testGetOptionValues_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderEnumOptionsExtensionListener ruleBuilderEnumOptionsExtensionListener = mock(
        RuleBuilderEnumOptionsExtensionListener.class);
    when(ruleBuilderEnumOptionsExtensionListener.getOptionValues()).thenReturn("42");

    ArrayList<RuleBuilderEnumOptionsExtensionListener> listeners = new ArrayList<>();
    listeners.add(ruleBuilderEnumOptionsExtensionListener);

    RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager = new RuleBuilderEnumOptionsExtensionManager();
    ruleBuilderEnumOptionsExtensionManager.setListeners(listeners);

    // Act
    String actualOptionValues = ruleBuilderEnumOptionsExtensionManager.getOptionValues();

    // Assert
    verify(ruleBuilderEnumOptionsExtensionListener).getOptionValues();
    assertEquals("42\r\n", actualOptionValues);
  }

  /**
   * Test {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderEnumOptionsExtensionManager#getOptionValues()}
   */
  @Test
  public void testGetOptionValues_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new RuleBuilderEnumOptionsExtensionManager()).getOptionValues());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleBuilderEnumOptionsExtensionManager#setListeners(List)}
   *   <li>{@link RuleBuilderEnumOptionsExtensionManager#getListeners()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager = new RuleBuilderEnumOptionsExtensionManager();
    ArrayList<RuleBuilderEnumOptionsExtensionListener> listeners = new ArrayList<>();

    // Act
    ruleBuilderEnumOptionsExtensionManager.setListeners(listeners);
    List<RuleBuilderEnumOptionsExtensionListener> actualListeners = ruleBuilderEnumOptionsExtensionManager
        .getListeners();

    // Assert that nothing has changed
    assertTrue(actualListeners.isEmpty());
    assertSame(listeners, actualListeners);
  }
}
