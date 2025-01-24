package org.broadleafcommerce.admin.web.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.admin.web.rulebuilder.service.extension.CookieFieldServiceExtensionHandler;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceExtensionManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminWebConfig.class, RuleBuilderFieldServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminWebConfigDiffblueTest {
  @Autowired
  private AdminWebConfig adminWebConfig;

  @Autowired
  private RuleBuilderFieldServiceExtensionManager ruleBuilderFieldServiceExtensionManager;

  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  public void testBlCookieFieldServiceExtensionHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult = adminWebConfig
        .blCookieFieldServiceExtensionHandler(new ArrayList<>(), mock(RuleBuilderFieldServiceExtensionManager.class));

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  public void testBlCookieFieldServiceExtensionHandler_given42_whenArrayListAdd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();

    ArrayList<Object> configs = new ArrayList<>();
    configs.add("42");

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult = adminWebConfig
        .blCookieFieldServiceExtensionHandler(configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  public void testBlCookieFieldServiceExtensionHandler_given42_whenArrayListAdd422() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();

    ArrayList<Object> configs = new ArrayList<>();
    configs.add("42");
    configs.add("42");

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult = adminWebConfig
        .blCookieFieldServiceExtensionHandler(configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  public void testBlCookieFieldServiceExtensionHandler_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminWebConfig adminWebConfig = new AdminWebConfig();
    ArrayList<Object> configs = new ArrayList<>();

    // Act
    CookieFieldServiceExtensionHandler actualBlCookieFieldServiceExtensionHandlerResult = adminWebConfig
        .blCookieFieldServiceExtensionHandler(configs, new RuleBuilderFieldServiceExtensionManager());

    // Assert
    assertEquals(0, actualBlCookieFieldServiceExtensionHandlerResult.getPriority());
    assertTrue(actualBlCookieFieldServiceExtensionHandlerResult.isEnabled());
  }

  /**
   * Test
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminWebConfig#blCookieFieldServiceExtensionHandler(List, RuleBuilderFieldServiceExtensionManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBlCookieFieldServiceExtensionHandler_whenArrayList2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'blCookieFieldServiceExtensionHandler' available
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ArrayList<Object> configs = new ArrayList<>();

    // Act
    adminWebConfig.blCookieFieldServiceExtensionHandler(configs, ruleBuilderFieldServiceExtensionManager);
  }
}
