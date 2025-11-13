package org.broadleafcommerce.core.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractAdditionStatusDaoExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractAdditionStatusDaoExtensionHandler#cleanUpEntity(Object)}.
   *
   * <p>Method under test: {@link AbstractAdditionStatusDaoExtensionHandler#cleanUpEntity(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdditionStatusDaoExtensionHandler.cleanUpEntity(Object)"
  })
  public void testCleanUpEntity() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        new AbstractAdditionStatusDaoExtensionHandler().cleanUpEntity("Entity"));
  }

  /**
   * Test new {@link AbstractAdditionStatusDaoExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractAdditionStatusDaoExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAdditionStatusDaoExtensionHandler.<init>()"})
  public void testNewAbstractAdditionStatusDaoExtensionHandler() {
    // Arrange and Act
    AbstractAdditionStatusDaoExtensionHandler actualAbstractAdditionStatusDaoExtensionHandler =
        new AbstractAdditionStatusDaoExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAdditionStatusDaoExtensionHandler.getPriority());
    assertTrue(actualAbstractAdditionStatusDaoExtensionHandler.isEnabled());
  }
}
