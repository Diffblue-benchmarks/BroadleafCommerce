/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.AbstractMultiTenantCopierExtensionHandler;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractExtensionHandler#getPriority()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractExtensionHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractExtensionHandler.getPriority()"})
  public void testGetPriority_thenReturnOne() {
    // Arrange
    AbstractMultiTenantCopierExtensionHandler abstractMultiTenantCopierExtensionHandler =
        new AbstractMultiTenantCopierExtensionHandler();
    abstractMultiTenantCopierExtensionHandler.setPriority(1);

    // Act and Assert
    assertEquals(1, abstractMultiTenantCopierExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractExtensionHandler#setPriority(int)}.
   *
   * <p>Method under test: {@link AbstractExtensionHandler#setPriority(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractExtensionHandler.setPriority(int)"})
  public void testSetPriority() {
    // Arrange
    AbstractMultiTenantCopierExtensionHandler abstractMultiTenantCopierExtensionHandler =
        new AbstractMultiTenantCopierExtensionHandler();

    // Act
    abstractMultiTenantCopierExtensionHandler.setPriority(1);

    // Assert
    assertEquals(1, abstractMultiTenantCopierExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractExtensionHandler#isEnabled()}.
   *
   * <ul>
   *   <li>Given {@link AbstractMultiTenantCopierExtensionHandler} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractExtensionHandler#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractExtensionHandler.isEnabled()"})
  public void testIsEnabled_givenAbstractMultiTenantCopierExtensionHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new AbstractMultiTenantCopierExtensionHandler().isEnabled());
  }

  /**
   * Test {@link AbstractExtensionHandler#isEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractExtensionHandler#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractExtensionHandler.isEnabled()"})
  public void testIsEnabled_thenReturnFalse() {
    // Arrange
    AbstractMultiTenantCopierExtensionHandler abstractMultiTenantCopierExtensionHandler =
        new AbstractMultiTenantCopierExtensionHandler();
    abstractMultiTenantCopierExtensionHandler.setEnabled(false);

    // Act and Assert
    assertFalse(abstractMultiTenantCopierExtensionHandler.isEnabled());
  }
}
