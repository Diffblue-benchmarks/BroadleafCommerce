package org.broadleafcommerce.openadmin.server.service.persistence.module.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AbstractBasicPersistenceModuleExtensionHandlerDiffblueTest {
  /**
   * Test new {@link AbstractBasicPersistenceModuleExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractBasicPersistenceModuleExtensionHandler}
   */
  @Test
  public void testNewAbstractBasicPersistenceModuleExtensionHandler() {
    // Arrange and Act
    AbstractBasicPersistenceModuleExtensionHandler actualAbstractBasicPersistenceModuleExtensionHandler = new AbstractBasicPersistenceModuleExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractBasicPersistenceModuleExtensionHandler.getPriority());
    assertTrue(actualAbstractBasicPersistenceModuleExtensionHandler.isEnabled());
  }
}
