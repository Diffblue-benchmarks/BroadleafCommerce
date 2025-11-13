package org.broadleafcommerce.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPurgeSandboxClonedEntitiesExtensionHandlerDiffblueTest {
  /**
   * Test new {@link AbstractPurgeSandboxClonedEntitiesExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractPurgeSandboxClonedEntitiesExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractPurgeSandboxClonedEntitiesExtensionHandler.<init>()"})
  public void testNewAbstractPurgeSandboxClonedEntitiesExtensionHandler() {
    // Arrange and Act
    AbstractPurgeSandboxClonedEntitiesExtensionHandler
        actualAbstractPurgeSandboxClonedEntitiesExtensionHandler =
            new AbstractPurgeSandboxClonedEntitiesExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractPurgeSandboxClonedEntitiesExtensionHandler.getPriority());
    assertTrue(actualAbstractPurgeSandboxClonedEntitiesExtensionHandler.isEnabled());
  }
}
