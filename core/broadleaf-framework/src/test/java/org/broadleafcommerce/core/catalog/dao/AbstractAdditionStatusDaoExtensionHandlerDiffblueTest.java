package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;

public class AbstractAdditionStatusDaoExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractAdditionStatusDaoExtensionHandler#cleanUpEntity(Object)}.
   * <p>
   * Method under test:
   * {@link AbstractAdditionStatusDaoExtensionHandler#cleanUpEntity(Object)}
   */
  @Test
  public void testCleanUpEntity() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new AbstractAdditionStatusDaoExtensionHandler()).cleanUpEntity("Entity"));
  }

  /**
   * Test new {@link AbstractAdditionStatusDaoExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractAdditionStatusDaoExtensionHandler}
   */
  @Test
  public void testNewAbstractAdditionStatusDaoExtensionHandler() {
    // Arrange and Act
    AbstractAdditionStatusDaoExtensionHandler actualAbstractAdditionStatusDaoExtensionHandler = new AbstractAdditionStatusDaoExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAdditionStatusDaoExtensionHandler.getPriority());
    assertTrue(actualAbstractAdditionStatusDaoExtensionHandler.isEnabled());
  }
}
