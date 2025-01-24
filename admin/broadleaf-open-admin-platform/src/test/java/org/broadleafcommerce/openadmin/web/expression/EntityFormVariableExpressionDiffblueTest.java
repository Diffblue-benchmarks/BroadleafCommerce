package org.broadleafcommerce.openadmin.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
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
public class EntityFormVariableExpressionDiffblueTest {
  @Autowired
  private EntityFormVariableExpression entityFormVariableExpression;

  /**
   * Test {@link EntityFormVariableExpression#getName()}.
   * <p>
   * Method under test: {@link EntityFormVariableExpression#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("ef", (new EntityFormVariableExpression()).getName());
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTabActive() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass573 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.expression.EntityFormVariableExpression entityFormVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression2 = new EntityFormVariableExpression();
    EntityForm ef = new EntityForm();

    // Act
    entityFormVariableExpression2.isTabActive(ef, new Tab());
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_givenHashSetAddNull_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(null);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getTabs()).thenReturn(tabSet);

    // Act
    boolean actualIsTabActiveResult = entityFormVariableExpression.isTabActive(ef, null);

    // Assert
    verify(ef).getTabs();
    assertTrue(actualIsTabActiveResult);
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Tab} (default
   * constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_givenHashSetAddTab_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(new Tab());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getTabs()).thenReturn(tabSet);

    // Act
    boolean actualIsTabActiveResult = entityFormVariableExpression.isTabActive(ef, new Tab());

    // Assert
    verify(ef).getTabs();
    assertFalse(actualIsTabActiveResult);
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>When {@link EntityForm} {@link EntityForm#getTabs()} return
   * {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_givenHashSet_whenEntityFormGetTabsReturnHashSet_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getTabs()).thenReturn(new HashSet<>());

    // Act
    boolean actualIsTabActiveResult = entityFormVariableExpression.isTabActive(ef, new Tab());

    // Assert
    verify(ef).getTabs();
    assertFalse(actualIsTabActiveResult);
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>Given {@link Tab} {@link Tab#getIsVisible()} return {@code true}.</li>
   *   <li>Then calls {@link Tab#getIsVisible()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_givenTabGetIsVisibleReturnTrue_thenCallsGetIsVisible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();
    Tab tab = mock(Tab.class);
    when(tab.getIsVisible()).thenReturn(true);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getTabs()).thenReturn(tabSet);

    // Act
    boolean actualIsTabActiveResult = entityFormVariableExpression.isTabActive(ef, new Tab());

    // Assert
    verify(ef).getTabs();
    verify(tab).getIsVisible();
    assertFalse(actualIsTabActiveResult);
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  public void testIsTabActive_whenEntityForm_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertFalse(entityFormVariableExpression.isTabActive(ef, new Tab()));
  }
}
