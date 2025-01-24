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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertFalse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.WriteListener;
import org.junit.Ignore;
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
   * Test {@link ServletOutputStreamWrapper#write(int)} with {@code int}.
   * <p>
   * Method under test: {@link ServletOutputStreamWrapper#write(int)}
   */
  @Test
  public void testWriteWithInt() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new ServletOutputStreamWrapper(new ByteArrayOutputStream(1))).write(19088743);
  }

  /**
   * Test {@link ServletOutputStreamWrapper#flush()}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServletOutputStreamWrapper#flush()}
   */
  @Test
  public void testFlush_givenByteArrayOutputStreamWithOne() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new ServletOutputStreamWrapper(new ByteArrayOutputStream(1))).flush();
  }

  /**
   * Test {@link ServletOutputStreamWrapper#flush()}.
   * <ul>
   *   <li>Given
   * {@link ServletOutputStreamWrapper#ServletOutputStreamWrapper(OutputStream)}
   * with outputStream is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServletOutputStreamWrapper#flush()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFlush_givenServletOutputStreamWrapperWithOutputStreamIsNull() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.util.ServletOutputStreamWrapper.flushInternalBuffer(ServletOutputStreamWrapper.java:57)
    //       at org.broadleafcommerce.common.web.util.ServletOutputStreamWrapper.flush(ServletOutputStreamWrapper.java:53)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ServletOutputStreamWrapper(null)).flush();
  }

  /**
   * Test {@link ServletOutputStreamWrapper#flushInternalBuffer()}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServletOutputStreamWrapper#flushInternalBuffer()}
   */
  @Test
  public void testFlushInternalBuffer_givenByteArrayOutputStreamWithOne() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new ServletOutputStreamWrapper(new ByteArrayOutputStream(1))).flushInternalBuffer();
  }

  /**
   * Test {@link ServletOutputStreamWrapper#flushInternalBuffer()}.
   * <ul>
   *   <li>Given
   * {@link ServletOutputStreamWrapper#ServletOutputStreamWrapper(OutputStream)}
   * with outputStream is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServletOutputStreamWrapper#flushInternalBuffer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFlushInternalBuffer_givenServletOutputStreamWrapperWithOutputStreamIsNull() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.util.ServletOutputStreamWrapper.flushInternalBuffer(ServletOutputStreamWrapper.java:57)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new ServletOutputStreamWrapper(null)).flushInternalBuffer();
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
