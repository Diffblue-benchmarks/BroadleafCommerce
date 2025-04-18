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
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GloballySharedInputStreamDiffblueTest {
  /**
   * Test {@link GloballySharedInputStream#GloballySharedInputStream(InputStream)}.
   * <p>
   * Method under test: {@link GloballySharedInputStream#GloballySharedInputStream(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GloballySharedInputStream.<init>(InputStream)"})
  public void testNewGloballySharedInputStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new GloballySharedInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read(new byte[8]));
  }

  /**
   * Test {@link GloballySharedInputStream#available()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#available()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int GloballySharedInputStream.available()"})
  public void testAvailable_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnEight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new GloballySharedInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
  }

  /**
   * Test {@link GloballySharedInputStream#available()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#available()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int GloballySharedInputStream.available()"})
  public void testAvailable_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.available()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).available());
    verify(parentInputStream).available();
  }

  /**
   * Test {@link GloballySharedInputStream#close()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#close()} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GloballySharedInputStream.close()"})
  public void testClose_givenDataInputStreamCloseThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(parentInputStream).close();

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).close());
    verify(parentInputStream).close();
  }

  /**
   * Test {@link GloballySharedInputStream#markSupported()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#markSupported()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#markSupported()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GloballySharedInputStream.markSupported()"})
  public void testMarkSupported_givenDataInputStreamMarkSupportedReturnFalse_thenReturnFalse() {
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
   * Test {@link GloballySharedInputStream#markSupported()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#markSupported()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GloballySharedInputStream.markSupported()"})
  public void testMarkSupported_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue((new GloballySharedInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
  }

  /**
   * Test {@link GloballySharedInputStream#read(byte[])} with {@code arg0}.
   * <p>
   * Method under test: {@link GloballySharedInputStream#read(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int GloballySharedInputStream.read(byte[])"})
  public void testReadWithArg0() throws IOException {
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
   * Test {@link GloballySharedInputStream#read(byte[], int, int)} with {@code arg0}, {@code arg1}, {@code arg2}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#read(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int GloballySharedInputStream.read(byte[], int, int)"})
  public void testReadWithArg0Arg1Arg2_thenReturnOne() throws IOException {
    // Arrange
    GloballySharedInputStream globallySharedInputStream = new GloballySharedInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] arg0 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, globallySharedInputStream.read(arg0, 1, 1));
    byte[] arg02 = new byte[7];
    assertEquals(7, globallySharedInputStream.read(arg02));
    assertArrayEquals("AAAXAXAX".getBytes("UTF-8"), arg0);
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), arg02);
  }

  /**
   * Test {@link GloballySharedInputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#read()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int GloballySharedInputStream.read()"})
  public void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
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
   * Test {@link GloballySharedInputStream#read()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#read()} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#read()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int GloballySharedInputStream.read()"})
  public void testRead_givenDataInputStreamReadThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.read()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).read());
    verify(parentInputStream).read();
  }

  /**
   * Test {@link GloballySharedInputStream#reset()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#reset()} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GloballySharedInputStream.reset()"})
  public void testReset_givenDataInputStreamResetThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(parentInputStream).reset();

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).reset());
    verify(parentInputStream).reset();
  }

  /**
   * Test {@link GloballySharedInputStream#skip(long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#skip(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long GloballySharedInputStream.skip(long)"})
  public void testSkip_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnOne() throws IOException {
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
   * Test {@link GloballySharedInputStream#skip(long)}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#skip(long)} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GloballySharedInputStream#skip(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long GloballySharedInputStream.skip(long)"})
  public void testSkip_givenDataInputStreamSkipThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream parentInputStream = mock(DataInputStream.class);
    when(parentInputStream.skip(anyLong())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new GloballySharedInputStream(parentInputStream)).skip(1L));
    verify(parentInputStream).skip(eq(1L));
  }
}
