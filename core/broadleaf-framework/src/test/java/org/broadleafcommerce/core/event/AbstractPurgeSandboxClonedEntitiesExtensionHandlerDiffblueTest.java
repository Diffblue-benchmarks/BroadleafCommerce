package org.broadleafcommerce.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;

public class AbstractPurgeSandboxClonedEntitiesExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractPurgeSandboxClonedEntitiesExtensionHandler#cleanUpAndDeleteEntity(Serializable, Object)}.
   * <p>
   * Method under test:
   * {@link AbstractPurgeSandboxClonedEntitiesExtensionHandler#cleanUpAndDeleteEntity(Serializable, Object)}
   */
  @Test
  public void testCleanUpAndDeleteEntity() {
    // Arrange
    AbstractPurgeSandboxClonedEntitiesExtensionHandler abstractPurgeSandboxClonedEntitiesExtensionHandler = new AbstractPurgeSandboxClonedEntitiesExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractPurgeSandboxClonedEntitiesExtensionHandler
        .cleanUpAndDeleteEntity(new SimpleDateFormat("yyyy/mm/dd"), "Entity"));
  }

  /**
   * Test new {@link AbstractPurgeSandboxClonedEntitiesExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractPurgeSandboxClonedEntitiesExtensionHandler}
   */
  @Test
  public void testNewAbstractPurgeSandboxClonedEntitiesExtensionHandler() {
    // Arrange and Act
    AbstractPurgeSandboxClonedEntitiesExtensionHandler actualAbstractPurgeSandboxClonedEntitiesExtensionHandler = new AbstractPurgeSandboxClonedEntitiesExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractPurgeSandboxClonedEntitiesExtensionHandler.getPriority());
    assertTrue(actualAbstractPurgeSandboxClonedEntitiesExtensionHandler.isEnabled());
  }
}
