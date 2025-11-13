package org.broadleafcommerce.openadmin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractFilterProductTypePersistenceHandlerExtensionHandlerDiffblueTest {
  /**
   * Test {@link
   * AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}.
   *
   * <p>Method under test: {@link
   * AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractFilterProductTypePersistenceHandlerExtensionHandler.manageAdditionalFilterMappings(CriteriaTransferObject)"
  })
  public void testManageAdditionalFilterMappings() throws ServiceException {
    // Arrange
    AbstractFilterProductTypePersistenceHandlerExtensionHandler
        abstractFilterProductTypePersistenceHandlerExtensionHandler =
            new AbstractFilterProductTypePersistenceHandlerExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractFilterProductTypePersistenceHandlerExtensionHandler.manageAdditionalFilterMappings(
            new CriteriaTransferObject()));
  }

  /**
   * Test new {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler} (default
   * constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractFilterProductTypePersistenceHandlerExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractFilterProductTypePersistenceHandlerExtensionHandler.<init>()"})
  public void testNewAbstractFilterProductTypePersistenceHandlerExtensionHandler() {
    // Arrange and Act
    AbstractFilterProductTypePersistenceHandlerExtensionHandler
        actualAbstractFilterProductTypePersistenceHandlerExtensionHandler =
            new AbstractFilterProductTypePersistenceHandlerExtensionHandler();

    // Assert
    assertEquals(
        0, actualAbstractFilterProductTypePersistenceHandlerExtensionHandler.getPriority());
    assertTrue(actualAbstractFilterProductTypePersistenceHandlerExtensionHandler.isEnabled());
  }
}
