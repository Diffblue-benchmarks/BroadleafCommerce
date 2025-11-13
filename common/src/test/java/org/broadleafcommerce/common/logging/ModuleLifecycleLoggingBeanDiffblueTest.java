package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModuleLifecycleLoggingBeanDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleLifecycleLoggingBean#ModuleLifecycleLoggingBean()}
   *   <li>{@link ModuleLifecycleLoggingBean#setLifeCycleEvent(LifeCycleEvent)}
   *   <li>{@link ModuleLifecycleLoggingBean#setModuleName(String)}
   *   <li>{@link ModuleLifecycleLoggingBean#getLifeCycleEvent()}
   *   <li>{@link ModuleLifecycleLoggingBean#getModuleName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ModuleLifecycleLoggingBean.<init>()",
    "void ModuleLifecycleLoggingBean.<init>(String, LifeCycleEvent)",
    "LifeCycleEvent ModuleLifecycleLoggingBean.getLifeCycleEvent()",
    "String ModuleLifecycleLoggingBean.getModuleName()",
    "void ModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent)",
    "void ModuleLifecycleLoggingBean.setModuleName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ModuleLifecycleLoggingBean actualModuleLifecycleLoggingBean = new ModuleLifecycleLoggingBean();
    actualModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setModuleName("Module Name");
    LifeCycleEvent actualLifeCycleEvent = actualModuleLifecycleLoggingBean.getLifeCycleEvent();

    // Assert
    assertEquals("Module Name", actualModuleLifecycleLoggingBean.getModuleName());
    assertEquals(LifeCycleEvent.START, actualLifeCycleEvent);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Module Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleLifecycleLoggingBean#ModuleLifecycleLoggingBean(String, LifeCycleEvent)}
   *   <li>{@link ModuleLifecycleLoggingBean#setLifeCycleEvent(LifeCycleEvent)}
   *   <li>{@link ModuleLifecycleLoggingBean#setModuleName(String)}
   *   <li>{@link ModuleLifecycleLoggingBean#getLifeCycleEvent()}
   *   <li>{@link ModuleLifecycleLoggingBean#getModuleName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ModuleLifecycleLoggingBean.<init>()",
    "void ModuleLifecycleLoggingBean.<init>(String, LifeCycleEvent)",
    "LifeCycleEvent ModuleLifecycleLoggingBean.getLifeCycleEvent()",
    "String ModuleLifecycleLoggingBean.getModuleName()",
    "void ModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent)",
    "void ModuleLifecycleLoggingBean.setModuleName(String)"
  })
  public void testGettersAndSetters_whenModuleName() {
    // Arrange and Act
    ModuleLifecycleLoggingBean actualModuleLifecycleLoggingBean =
        new ModuleLifecycleLoggingBean("Module Name", LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setModuleName("Module Name");
    LifeCycleEvent actualLifeCycleEvent = actualModuleLifecycleLoggingBean.getLifeCycleEvent();

    // Assert
    assertEquals("Module Name", actualModuleLifecycleLoggingBean.getModuleName());
    assertEquals(LifeCycleEvent.START, actualLifeCycleEvent);
  }

  /**
   * Test {@link ModuleLifecycleLoggingBean#init()}.
   *
   * <p>Method under test: {@link ModuleLifecycleLoggingBean#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ModuleLifecycleLoggingBean.init()"})
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ModuleLifecycleLoggingBean(null, LifeCycleEvent.START).init());
  }

  /**
   * Test {@link ModuleLifecycleLoggingBean#init()}.
   *
   * <ul>
   *   <li>Given {@link ModuleLifecycleLoggingBean#ModuleLifecycleLoggingBean(String,
   *       LifeCycleEvent)} with {@code Module Name} and lifeCycleEvent is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleLifecycleLoggingBean#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ModuleLifecycleLoggingBean.init()"})
  public void testInit_givenModuleLifecycleLoggingBeanWithModuleNameAndLifeCycleEventIsNull() {
    // Arrange
    ModuleLifecycleLoggingBean moduleLifecycleLoggingBean =
        new ModuleLifecycleLoggingBean("Module Name", null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> moduleLifecycleLoggingBean.init());
  }

  /**
   * Test {@link ModuleLifecycleLoggingBean#init()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ModuleLifecycleLoggingBean#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ModuleLifecycleLoggingBean.init()"})
  public void testInit_thenDoesNotThrow() {
    // Arrange, Act and Assert
    new ModuleLifecycleLoggingBean("Module Name", LifeCycleEvent.START).init();
  }
}
