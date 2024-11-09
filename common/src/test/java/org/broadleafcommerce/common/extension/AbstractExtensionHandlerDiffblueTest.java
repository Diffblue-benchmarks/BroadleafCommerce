/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.copy.AbstractMultiTenantCopierExtensionHandler;
import org.junit.Test;

public class AbstractExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractExtensionHandler#getPriority()}.
   * <p>
   * Method under test: {@link AbstractExtensionHandler#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(0, (new AbstractMultiTenantCopierExtensionHandler()).getPriority());
  }

  /**
   * Test {@link AbstractExtensionHandler#setPriority(int)}.
   * <p>
   * Method under test: {@link AbstractExtensionHandler#setPriority(int)}
   */
  @Test
  public void testSetPriority() {
    // Arrange
    AbstractMultiTenantCopierExtensionHandler abstractMultiTenantCopierExtensionHandler = new AbstractMultiTenantCopierExtensionHandler();

    // Act
    abstractMultiTenantCopierExtensionHandler.setPriority(1);

    // Assert
    assertEquals(1, abstractMultiTenantCopierExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractExtensionHandler#isEnabled()}.
   * <ul>
   *   <li>Given {@link AbstractMultiTenantCopierExtensionHandler} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractExtensionHandler#isEnabled()}
   */
  @Test
  public void testIsEnabled_givenAbstractMultiTenantCopierExtensionHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new AbstractMultiTenantCopierExtensionHandler()).isEnabled());
  }

  /**
   * Test {@link AbstractExtensionHandler#isEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractExtensionHandler#isEnabled()}
   */
  @Test
  public void testIsEnabled_thenReturnFalse() {
    // Arrange
    AbstractMultiTenantCopierExtensionHandler abstractMultiTenantCopierExtensionHandler = new AbstractMultiTenantCopierExtensionHandler();
    abstractMultiTenantCopierExtensionHandler.setEnabled(false);

    // Act and Assert
    assertFalse(abstractMultiTenantCopierExtensionHandler.isEnabled());
  }
}
