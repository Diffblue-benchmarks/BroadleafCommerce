/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class AssetNotFoundExceptionDiffblueTest {
  /**
   * Method under test: {@link AssetNotFoundException#AssetNotFoundException()}
   */
  @Test
  public void testNewAssetNotFoundException() {
    // Arrange and Act
    AssetNotFoundException actualAssetNotFoundException = new AssetNotFoundException();

    // Assert
    assertNull(actualAssetNotFoundException.getMessage());
    assertNull(actualAssetNotFoundException.getCause());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link AssetNotFoundException#AssetNotFoundException(String)}
   */
  @Test
  public void testNewAssetNotFoundException2() {
    // Arrange and Act
    AssetNotFoundException actualAssetNotFoundException = new AssetNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAssetNotFoundException.getMessage());
    assertNull(actualAssetNotFoundException.getCause());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link AssetNotFoundException#AssetNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewAssetNotFoundException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AssetNotFoundException actualAssetNotFoundException = new AssetNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualAssetNotFoundException.getMessage());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
    assertSame(cause, actualAssetNotFoundException.getCause());
  }

  /**
   * Method under test:
   * {@link AssetNotFoundException#AssetNotFoundException(Throwable)}
   */
  @Test
  public void testNewAssetNotFoundException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    AssetNotFoundException actualAssetNotFoundException = new AssetNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualAssetNotFoundException.getMessage());
    assertEquals(0, actualAssetNotFoundException.getSuppressed().length);
    assertSame(cause, actualAssetNotFoundException.getCause());
  }
}
