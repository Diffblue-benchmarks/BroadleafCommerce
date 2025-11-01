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
package org.broadleafcommerce.common.file.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class GloballySharedInputStreamDiffblueTest {
  /**
   * Method under test: {@link GloballySharedInputStream#available()}
   */
  @Test
  public void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new GloballySharedInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
  }

  /**
   * Method under test: {@link GloballySharedInputStream#available()}
   */
  @Test
  public void testAvailable2() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.available()).thenReturn(1);

    // Act
    int actualAvailableResult = (new GloballySharedInputStream(parentInputStream)).available();

    // Assert
    verify(parentInputStream).available();
    assertEquals(1, actualAvailableResult);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#available()}
   */
  @Test
  public void testAvailable3() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.available()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).available());
    verify(parentInputStream).available();
  }

  /**
   * Method under test: {@link GloballySharedInputStream#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    doNothing().when(parentInputStream).close();

    // Act
    (new GloballySharedInputStream(parentInputStream)).close();

    // Assert that nothing has changed
    verify(parentInputStream).close();
  }

  /**
   * Method under test: {@link GloballySharedInputStream#close()}
   */
  @Test
  public void testClose2() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(parentInputStream).close();

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).close());
    verify(parentInputStream).close();
  }

  /**
   * Method under test: {@link GloballySharedInputStream#mark(int)}
   */
  @Test
  public void testMark() {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    doNothing().when(parentInputStream).mark(anyInt());

    // Act
    (new GloballySharedInputStream(parentInputStream)).mark(1);

    // Assert that nothing has changed
    verify(parentInputStream).mark(eq(1));
  }

  /**
   * Method under test: {@link GloballySharedInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue((new GloballySharedInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
  }

  /**
   * Method under test: {@link GloballySharedInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported2() {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.markSupported()).thenReturn(true);

    // Act
    boolean actualMarkSupportedResult = (new GloballySharedInputStream(parentInputStream)).markSupported();

    // Assert
    verify(parentInputStream).markSupported();
    assertTrue(actualMarkSupportedResult);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported3() {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.markSupported()).thenReturn(false);

    // Act
    boolean actualMarkSupportedResult = (new GloballySharedInputStream(parentInputStream)).markSupported();

    // Assert
    verify(parentInputStream).markSupported();
    assertFalse(actualMarkSupportedResult);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#read()}
   */
  @Test
  public void testRead() throws IOException {
    // Arrange
    GloballySharedInputStream globallySharedInputStream = new GloballySharedInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(65, globallySharedInputStream.read());
    byte[] arg0 = new byte[7];
    assertEquals(7, globallySharedInputStream.read(arg0));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), arg0);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#read()}
   */
  @Test
  public void testRead2() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.read()).thenReturn(1);

    // Act
    int actualReadResult = (new GloballySharedInputStream(parentInputStream)).read();

    // Assert
    verify(parentInputStream).read();
    assertEquals(1, actualReadResult);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#read()}
   */
  @Test
  public void testRead3() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.read()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).read());
    verify(parentInputStream).read();
  }

  /**
   * Method under test: {@link GloballySharedInputStream#read(byte[])}
   */
  @Test
  public void testRead4() throws IOException {
    // Arrange
    GloballySharedInputStream globallySharedInputStream = new GloballySharedInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    int actualReadResult = globallySharedInputStream.read("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, globallySharedInputStream.read(new byte[]{}));
    assertEquals(8, actualReadResult);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#read(byte[], int, int)}
   */
  @Test
  public void testRead5() throws IOException {
    // Arrange
    GloballySharedInputStream globallySharedInputStream = new GloballySharedInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] arg0 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, globallySharedInputStream.read(arg0, 1, 1));
    byte[] arg02 = new byte[7];
    assertEquals(7, globallySharedInputStream.read(arg02));
    assertEquals(8, arg0.length);
    assertEquals('A', arg0[1]);
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), arg02);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#reset()}
   */
  @Test
  public void testReset() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    doNothing().when(parentInputStream).reset();

    // Act
    (new GloballySharedInputStream(parentInputStream)).reset();

    // Assert that nothing has changed
    verify(parentInputStream).reset();
  }

  /**
   * Method under test: {@link GloballySharedInputStream#reset()}
   */
  @Test
  public void testReset2() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(parentInputStream).reset();

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).reset());
    verify(parentInputStream).reset();
  }

  /**
   * Method under test: {@link GloballySharedInputStream#skip(long)}
   */
  @Test
  public void testSkip() throws IOException {
    // Arrange
    GloballySharedInputStream globallySharedInputStream = new GloballySharedInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(1L, globallySharedInputStream.skip(1L));
    byte[] arg0 = new byte[7];
    assertEquals(7, globallySharedInputStream.read(arg0));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), arg0);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#skip(long)}
   */
  @Test
  public void testSkip2() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.skip(anyLong())).thenReturn(1L);

    // Act
    long actualSkipResult = (new GloballySharedInputStream(parentInputStream)).skip(1L);

    // Assert
    verify(parentInputStream).skip(eq(1L));
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link GloballySharedInputStream#skip(long)}
   */
  @Test
  public void testSkip3() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.skip(anyLong())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).skip(1L));
    verify(parentInputStream).skip(eq(1L));
  }

  /**
   * Method under test:
   * {@link GloballySharedInputStream#GloballySharedInputStream(InputStream)}
   */
  @Test
  public void testNewGloballySharedInputStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new GloballySharedInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read(new byte[8]));
  }
}
