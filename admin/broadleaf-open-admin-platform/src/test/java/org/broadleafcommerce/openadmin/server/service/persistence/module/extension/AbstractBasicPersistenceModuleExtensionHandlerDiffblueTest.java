package org.broadleafcommerce.openadmin.server.service.persistence.module.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractBasicPersistenceModuleExtensionHandlerDiffblueTest {
  /**
   * Test new {@link AbstractBasicPersistenceModuleExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractBasicPersistenceModuleExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractBasicPersistenceModuleExtensionHandler.<init>()"})
  public void testNewAbstractBasicPersistenceModuleExtensionHandler() {
    // Arrange and Act
    AbstractBasicPersistenceModuleExtensionHandler
        actualAbstractBasicPersistenceModuleExtensionHandler =
            new AbstractBasicPersistenceModuleExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractBasicPersistenceModuleExtensionHandler.getPriority());
    assertTrue(actualAbstractBasicPersistenceModuleExtensionHandler.isEnabled());
  }
}
