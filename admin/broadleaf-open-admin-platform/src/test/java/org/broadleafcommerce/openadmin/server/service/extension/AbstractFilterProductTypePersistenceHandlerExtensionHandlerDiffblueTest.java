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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractFilterProductTypePersistenceHandlerExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}.
   * <p>
   * Method under test: {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler#manageAdditionalFilterMappings(CriteriaTransferObject)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractFilterProductTypePersistenceHandlerExtensionHandler.manageAdditionalFilterMappings(CriteriaTransferObject)"})
  public void testManageAdditionalFilterMappings() throws ServiceException {
    // Arrange
    AbstractFilterProductTypePersistenceHandlerExtensionHandler abstractFilterProductTypePersistenceHandlerExtensionHandler = new AbstractFilterProductTypePersistenceHandlerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractFilterProductTypePersistenceHandlerExtensionHandler
        .manageAdditionalFilterMappings(new CriteriaTransferObject()));
  }

  /**
   * Test new {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AbstractFilterProductTypePersistenceHandlerExtensionHandler}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractFilterProductTypePersistenceHandlerExtensionHandler.<init>()"})
  public void testNewAbstractFilterProductTypePersistenceHandlerExtensionHandler() {
    // Arrange and Act
    AbstractFilterProductTypePersistenceHandlerExtensionHandler actualAbstractFilterProductTypePersistenceHandlerExtensionHandler = new AbstractFilterProductTypePersistenceHandlerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractFilterProductTypePersistenceHandlerExtensionHandler.getPriority());
    assertTrue(actualAbstractFilterProductTypePersistenceHandlerExtensionHandler.isEnabled());
  }
}
