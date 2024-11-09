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
package org.broadleafcommerce.common.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class SiteNotFoundExceptionDiffblueTest {
  /**
   * Test {@link SiteNotFoundException#SiteNotFoundException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteNotFoundException#SiteNotFoundException(String)}
   */
  @Test
  public void testNewSiteNotFoundException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    SiteNotFoundException actualSiteNotFoundException = new SiteNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSiteNotFoundException.getMessage());
    assertNull(actualSiteNotFoundException.getCause());
    assertEquals(0, actualSiteNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link SiteNotFoundException#SiteNotFoundException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteNotFoundException#SiteNotFoundException(String, Throwable)}
   */
  @Test
  public void testNewSiteNotFoundException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SiteNotFoundException actualSiteNotFoundException = new SiteNotFoundException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualSiteNotFoundException.getMessage());
    assertEquals(0, actualSiteNotFoundException.getSuppressed().length);
    assertSame(cause, actualSiteNotFoundException.getCause());
  }

  /**
   * Test {@link SiteNotFoundException#SiteNotFoundException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteNotFoundException#SiteNotFoundException()}
   */
  @Test
  public void testNewSiteNotFoundException_thenReturnMessageIsNull() {
    // Arrange and Act
    SiteNotFoundException actualSiteNotFoundException = new SiteNotFoundException();

    // Assert
    assertNull(actualSiteNotFoundException.getMessage());
    assertNull(actualSiteNotFoundException.getCause());
    assertEquals(0, actualSiteNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link SiteNotFoundException#SiteNotFoundException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteNotFoundException#SiteNotFoundException(Throwable)}
   */
  @Test
  public void testNewSiteNotFoundException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SiteNotFoundException actualSiteNotFoundException = new SiteNotFoundException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualSiteNotFoundException.getMessage());
    assertEquals(0, actualSiteNotFoundException.getSuppressed().length);
    assertSame(cause, actualSiteNotFoundException.getCause());
  }
}
