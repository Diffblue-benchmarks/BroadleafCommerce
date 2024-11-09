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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SandBoxContextDiffblueTest {
  /**
   * Test {@link SandBoxContext#getSandBoxContext()}.
   * <p>
   * Method under test: {@link SandBoxContext#getSandBoxContext()}
   */
  @Test
  public void testGetSandBoxContext() {
    // Arrange and Act
    SandBoxContext actualSandBoxContext = SandBoxContext.getSandBoxContext();

    // Assert
    assertNull(actualSandBoxContext.getSandBoxId());
    assertFalse(actualSandBoxContext.getPreviewMode());
  }

  /**
   * Test {@link SandBoxContext#clone()}.
   * <p>
   * Method under test: {@link SandBoxContext#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    SandBoxContext actualCloneResult = (new SandBoxContext()).clone();

    // Assert
    assertNull(actualCloneResult.getSandBoxId());
    assertFalse(actualCloneResult.getPreviewMode());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SandBoxContext}
   *   <li>{@link SandBoxContext#setPreviewMode(Boolean)}
   *   <li>{@link SandBoxContext#setSandBoxId(Long)}
   *   <li>{@link SandBoxContext#getPreviewMode()}
   *   <li>{@link SandBoxContext#getSandBoxId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SandBoxContext actualSandBoxContext = new SandBoxContext();
    actualSandBoxContext.setPreviewMode(true);
    actualSandBoxContext.setSandBoxId(1L);
    Boolean actualPreviewMode = actualSandBoxContext.getPreviewMode();

    // Assert that nothing has changed
    assertEquals(1L, actualSandBoxContext.getSandBoxId().longValue());
    assertTrue(actualPreviewMode);
  }
}
