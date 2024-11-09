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
package org.broadleafcommerce.common.sitemap.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class SiteMapExceptionDiffblueTest {
  /**
   * Test {@link SiteMapException#SiteMapException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapException#SiteMapException()}
   */
  @Test
  public void testNewSiteMapException_thenReturnMessageIsNull() {
    // Arrange and Act
    SiteMapException actualSiteMapException = new SiteMapException();

    // Assert
    assertNull(actualSiteMapException.getMessage());
    assertNull(actualSiteMapException.getCause());
    assertEquals(0, actualSiteMapException.getSuppressed().length);
  }

  /**
   * Test {@link SiteMapException#SiteMapException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapException#SiteMapException(String)}
   */
  @Test
  public void testNewSiteMapException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    SiteMapException actualSiteMapException = new SiteMapException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSiteMapException.getMessage());
    assertNull(actualSiteMapException.getCause());
    assertEquals(0, actualSiteMapException.getSuppressed().length);
  }

  /**
   * Test {@link SiteMapException#SiteMapException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapException#SiteMapException(String, Throwable)}
   */
  @Test
  public void testNewSiteMapException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SiteMapException actualSiteMapException = new SiteMapException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualSiteMapException.getMessage());
    assertEquals(0, actualSiteMapException.getSuppressed().length);
    assertSame(cause, actualSiteMapException.getCause());
  }

  /**
   * Test {@link SiteMapException#SiteMapException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapException#SiteMapException(Throwable)}
   */
  @Test
  public void testNewSiteMapException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SiteMapException actualSiteMapException = new SiteMapException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualSiteMapException.getMessage());
    assertEquals(0, actualSiteMapException.getSuppressed().length);
    assertSame(cause, actualSiteMapException.getCause());
  }
}
