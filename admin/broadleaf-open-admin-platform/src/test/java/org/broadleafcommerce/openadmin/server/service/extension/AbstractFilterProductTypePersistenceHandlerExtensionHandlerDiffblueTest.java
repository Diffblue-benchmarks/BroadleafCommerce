/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
   * Method under test:
   * {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}
   */
  @Test
  public void testManageAdditionalFilterMappings() throws ServiceException {
    // Arrange
    AbstractFilterProductTypePersistenceHandlerExtensionHandler abstractFilterProductTypePersistenceHandlerExtensionHandler = new AbstractFilterProductTypePersistenceHandlerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractFilterProductTypePersistenceHandlerExtensionHandler
        .manageAdditionalFilterMappings(new CriteriaTransferObject()));
  }

  /**
   * Method under test:
   * {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}
   */
  @Test
  public void testManageAdditionalFilterMappings2() throws ServiceException {
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
