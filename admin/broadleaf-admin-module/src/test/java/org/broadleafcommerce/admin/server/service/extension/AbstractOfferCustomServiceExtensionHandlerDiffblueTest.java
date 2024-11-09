/*-
 * #%L
 * BroadleafCommerce Admin Module
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.admin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.sql.Date;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;

public class AbstractOfferCustomServiceExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractOfferCustomServiceExtensionHandler#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>Given {@link Date}.</li>
   *   <li>When {@link Entity} (default constructor) DeployDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferCustomServiceExtensionHandler#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers_givenDate_whenEntityDeployDateIsDate() {
    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler = new AbstractOfferCustomServiceExtensionHandler();

    Entity entity = new Entity();
    entity.setDeployDate(mock(Date.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(entity));
  }

  /**
   * Test
   * {@link AbstractOfferCustomServiceExtensionHandler#clearHiddenQualifiers(Entity)}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOfferCustomServiceExtensionHandler#clearHiddenQualifiers(Entity)}
   */
  @Test
  public void testClearHiddenQualifiers_whenEntity() {
    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler = new AbstractOfferCustomServiceExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test new {@link AbstractOfferCustomServiceExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractOfferCustomServiceExtensionHandler}
   */
  @Test
  public void testNewAbstractOfferCustomServiceExtensionHandler() {
    // Arrange and Act
    AbstractOfferCustomServiceExtensionHandler actualAbstractOfferCustomServiceExtensionHandler = new AbstractOfferCustomServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractOfferCustomServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractOfferCustomServiceExtensionHandler.isEnabled());
  }
}
