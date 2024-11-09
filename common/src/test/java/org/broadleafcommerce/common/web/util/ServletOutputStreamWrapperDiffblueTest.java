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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertFalse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import javax.servlet.WriteListener;
import org.junit.Test;

public class ServletOutputStreamWrapperDiffblueTest {
  /**
   * Test
   * {@link ServletOutputStreamWrapper#ServletOutputStreamWrapper(OutputStream)}.
   * <p>
   * Method under test:
   * {@link ServletOutputStreamWrapper#ServletOutputStreamWrapper(OutputStream)}
   */
  @Test
  public void testNewServletOutputStreamWrapper() {
    // Arrange, Act and Assert
    assertFalse((new ServletOutputStreamWrapper(new ByteArrayOutputStream(1))).isReady());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ServletOutputStreamWrapper#setWriteListener(WriteListener)}
   *   <li>{@link ServletOutputStreamWrapper#isReady()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ServletOutputStreamWrapper servletOutputStreamWrapper = new ServletOutputStreamWrapper(
        new ByteArrayOutputStream(1));

    // Act
    servletOutputStreamWrapper.setWriteListener(null);

    // Assert that nothing has changed
    assertFalse(servletOutputStreamWrapper.isReady());
  }
}
