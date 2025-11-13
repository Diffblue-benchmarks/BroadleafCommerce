package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DisableSupportLoggerAdapterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DisableSupportLoggerAdapter}
   *   <li>{@link DisableSupportLoggerAdapter#debug(String)}
   *   <li>{@link DisableSupportLoggerAdapter#debug(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#error(String)}
   *   <li>{@link DisableSupportLoggerAdapter#error(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#fatal(String)}
   *   <li>{@link DisableSupportLoggerAdapter#fatal(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#info(String)}
   *   <li>{@link DisableSupportLoggerAdapter#info(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#lifecycle(LifeCycleEvent, String)}
   *   <li>{@link DisableSupportLoggerAdapter#setName(String)}
   *   <li>{@link DisableSupportLoggerAdapter#support(String)}
   *   <li>{@link DisableSupportLoggerAdapter#support(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#warn(String)}
   *   <li>{@link DisableSupportLoggerAdapter#warn(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DisableSupportLoggerAdapter.<init>()",
    "void DisableSupportLoggerAdapter.debug(String)",
    "void DisableSupportLoggerAdapter.debug(String, Throwable)",
    "void DisableSupportLoggerAdapter.error(String)",
    "void DisableSupportLoggerAdapter.error(String, Throwable)",
    "void DisableSupportLoggerAdapter.fatal(String)",
    "void DisableSupportLoggerAdapter.fatal(String, Throwable)",
    "String DisableSupportLoggerAdapter.getName()",
    "void DisableSupportLoggerAdapter.info(String)",
    "void DisableSupportLoggerAdapter.info(String, Throwable)",
    "void DisableSupportLoggerAdapter.lifecycle(LifeCycleEvent, String)",
    "void DisableSupportLoggerAdapter.setName(String)",
    "void DisableSupportLoggerAdapter.support(String)",
    "void DisableSupportLoggerAdapter.support(String, Throwable)",
    "void DisableSupportLoggerAdapter.warn(String)",
    "void DisableSupportLoggerAdapter.warn(String, Throwable)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DisableSupportLoggerAdapter actualDisableSupportLoggerAdapter =
        new DisableSupportLoggerAdapter();
    actualDisableSupportLoggerAdapter.debug("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.debug("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.error("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.error("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.fatal("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.fatal("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.info("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.info("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.lifecycle(
        LifeCycleEvent.START, "Not all who wander are lost");
    actualDisableSupportLoggerAdapter.setName("Name");
    actualDisableSupportLoggerAdapter.support("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.support("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.warn("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.warn("Not all who wander are lost", new Throwable());

    // Assert
    assertNull(actualDisableSupportLoggerAdapter.getName());
  }
}
