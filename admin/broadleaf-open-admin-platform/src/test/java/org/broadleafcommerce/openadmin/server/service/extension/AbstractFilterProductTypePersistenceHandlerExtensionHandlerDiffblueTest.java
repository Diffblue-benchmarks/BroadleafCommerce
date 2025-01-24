package org.broadleafcommerce.openadmin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.junit.Test;

public class AbstractFilterProductTypePersistenceHandlerExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}
   */
  @Test
  public void testManageAdditionalFilterMappings_givenHashMapComputeIfPresentFooAndBiFunction()
      throws ServiceException {
    // Arrange
    AbstractFilterProductTypePersistenceHandlerExtensionHandler abstractFilterProductTypePersistenceHandlerExtensionHandler = new AbstractFilterProductTypePersistenceHandlerExtensionHandler();

    HashMap<String, FilterAndSortCriteria> criteriaMap = new HashMap<>();
    criteriaMap.computeIfPresent("foo", mock(BiFunction.class));

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.setCriteriaMap(criteriaMap);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractFilterProductTypePersistenceHandlerExtensionHandler.manageAdditionalFilterMappings(cto));
  }

  /**
   * Test
   * {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}.
   * <ul>
   *   <li>When {@link CriteriaTransferObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}
   */
  @Test
  public void testManageAdditionalFilterMappings_whenCriteriaTransferObject() throws ServiceException {
    // Arrange
    AbstractFilterProductTypePersistenceHandlerExtensionHandler abstractFilterProductTypePersistenceHandlerExtensionHandler = new AbstractFilterProductTypePersistenceHandlerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractFilterProductTypePersistenceHandlerExtensionHandler
        .manageAdditionalFilterMappings(new CriteriaTransferObject()));
  }

  /**
   * Test new {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler}
   * (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler}
   */
  @Test
  public void testNewAbstractFilterProductTypePersistenceHandlerExtensionHandler() {
    // Arrange and Act
    AbstractFilterProductTypePersistenceHandlerExtensionHandler actualAbstractFilterProductTypePersistenceHandlerExtensionHandler = new AbstractFilterProductTypePersistenceHandlerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractFilterProductTypePersistenceHandlerExtensionHandler.getPriority());
    assertTrue(actualAbstractFilterProductTypePersistenceHandlerExtensionHandler.isEnabled());
  }
}
