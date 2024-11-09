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
package org.broadleafcommerce.common.extensibility.context.merge;

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
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ResourceInputStreamDiffblueTest {
  @MockBean
  private ResourceInputStream resourceInputStream;

  /**
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String)}.
   * <p>
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String)}
   */
  @Test
  public void testNewResourceInputStream() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    byte[] bytes = new byte[8];
    int actualReadResult = (new ResourceInputStream(is, "Name")).read(bytes);
    assertEquals(-1, is.read(new byte[]{}));
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  public void testNewResourceInputStream_given42_whenArrayListAdd42() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<String> previousNames = new ArrayList<>();
    previousNames.add("42");
    previousNames.add("foo");

    // Act and Assert
    byte[] bytes = new byte[8];
    int actualReadResult = (new ResourceInputStream(is, "Name", previousNames)).read(bytes);
    assertEquals(-1, is.read(new byte[]{}));
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  public void testNewResourceInputStream_givenFoo_whenArrayListAddFoo() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<String> previousNames = new ArrayList<>();
    previousNames.add("foo");

    // Act and Assert
    byte[] bytes = new byte[8];
    int actualReadResult = (new ResourceInputStream(is, "Name", previousNames)).read(bytes);
    assertEquals(-1, is.read(new byte[]{}));
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  public void testNewResourceInputStream_whenArrayList() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    byte[] bytes = new byte[8];
    int actualReadResult = (new ResourceInputStream(is, "Name", new ArrayList<>())).read(bytes);
    assertEquals(-1, is.read(new byte[]{}));
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  public void testNewResourceInputStream_whenEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    byte[] bytes = new byte[8];
    int actualReadResult = (new ResourceInputStream(is, "", new ArrayList<>())).read(bytes);
    assertEquals(-1, is.read(new byte[]{}));
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#getNames()}.
   * <p>
   * Method under test: {@link ResourceInputStream#getNames()}
   */
  @Test
  public void testGetNames() throws UnsupportedEncodingException {
    // Arrange and Act
    List<String> actualNames = (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name"))
        .getNames();

    // Assert
    assertEquals(1, actualNames.size());
    assertEquals("Name", actualNames.get(0));
  }

  /**
   * Test {@link ResourceInputStream#getName()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#getName()}
   */
  @Test
  public void testGetName_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).getName());
  }

  /**
   * Test {@link ResourceInputStream#getName()}.
   * <ul>
   *   <li>Given
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String)} with is
   * is {@link DataInputStream} and {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#getName()}
   */
  @Test
  public void testGetName_givenResourceInputStreamWithIsIsDataInputStreamAndName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new ResourceInputStream(mock(DataInputStream.class), "Name")).getName());
  }

  /**
   * Test {@link ResourceInputStream#toString()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#toString()}
   */
  @Test
  public void testToString_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).toString());
  }

  /**
   * Test {@link ResourceInputStream#toString()}.
   * <ul>
   *   <li>Given
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String)} with is
   * is {@link DataInputStream} and {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#toString()}
   */
  @Test
  public void testToString_givenResourceInputStreamWithIsIsDataInputStreamAndName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new ResourceInputStream(mock(DataInputStream.class), "Name")).toString());
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  public void testAvailable_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnEight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).available());
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#available()}
   * return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  public void testAvailable_givenDataInputStreamAvailableReturnOne_thenReturnOne() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.available()).thenReturn(1);

    // Act
    int actualAvailableResult = (new ResourceInputStream(is, "Name")).available();

    // Assert
    verify(is).available();
    assertEquals(1, actualAvailableResult);
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  public void testAvailable_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new ResourceInputStream(null, "Name", new ArrayList<>())).available());
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  public void testAvailable_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.available()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).available());
    verify(is).available();
  }

  /**
   * Test {@link ResourceInputStream#close()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#close()} does
   * nothing.</li>
   *   <li>Then calls {@link FilterInputStream#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#close()}
   */
  @Test
  public void testClose_givenDataInputStreamCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).close();

    // Act
    (new ResourceInputStream(is, "Name")).close();

    // Assert that nothing has changed
    verify(is).close();
  }

  /**
   * Test {@link ResourceInputStream#close()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#close()} throw
   * {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#close()}
   */
  @Test
  public void testClose_givenDataInputStreamCloseThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(is).close();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).close());
    verify(is).close();
  }

  /**
   * Test {@link ResourceInputStream#mark(int)}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#mark(int)} does
   * nothing.</li>
   *   <li>Then calls {@link FilterInputStream#mark(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#mark(int)}
   */
  @Test
  public void testMark_givenDataInputStreamMarkDoesNothing_thenCallsMark() {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).mark(anyInt());

    // Act
    (new ResourceInputStream(is, "Name")).mark(1);

    // Assert that nothing has changed
    verify(is).mark(eq(1));
  }

  /**
   * Test {@link ResourceInputStream#markSupported()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).markSupported());
  }

  /**
   * Test {@link ResourceInputStream#markSupported()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#markSupported()}
   * return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported_givenDataInputStreamMarkSupportedReturnFalse_thenReturnFalse() {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.markSupported()).thenReturn(false);

    // Act
    boolean actualMarkSupportedResult = (new ResourceInputStream(is, "Name")).markSupported();

    // Assert
    verify(is).markSupported();
    assertFalse(actualMarkSupportedResult);
  }

  /**
   * Test {@link ResourceInputStream#markSupported()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#markSupported()}
   * return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported_givenDataInputStreamMarkSupportedReturnTrue_thenReturnTrue() {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.markSupported()).thenReturn(true);

    // Act
    boolean actualMarkSupportedResult = (new ResourceInputStream(is, "Name")).markSupported();

    // Assert
    verify(is).markSupported();
    assertTrue(actualMarkSupportedResult);
  }

  /**
   * Test {@link ResourceInputStream#read(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link ResourceInputStream#read(byte[])}
   */
  @Test
  public void testReadWithBytes() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act
    int actualReadResult = resourceInputStream.read("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-1, resourceInputStream.read(new byte[]{}));
    assertEquals(8, actualReadResult);
  }

  /**
   * Test {@link ResourceInputStream#read(byte[], int, int)} with {@code bytes},
   * {@code i}, {@code i1}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#read(byte[], int, int)}
   */
  @Test
  public void testReadWithBytesII1_thenReturnOne() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, resourceInputStream.read(bytes, 1, 1));
    byte[] bytes2 = new byte[7];
    assertEquals(7, resourceInputStream.read(bytes2));
    assertEquals(8, bytes.length);
    assertEquals('A', bytes[1]);
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), bytes2);
  }

  /**
   * Test {@link ResourceInputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  public void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act and Assert
    assertEquals(65, resourceInputStream.read());
    byte[] bytes = new byte[7];
    assertEquals(7, resourceInputStream.read(bytes));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#read()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#read()} throw
   * {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  public void testRead_givenDataInputStreamReadThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).read());
    verify(is).read();
  }

  /**
   * Test {@link ResourceInputStream#reset()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#reset()} does
   * nothing.</li>
   *   <li>Then calls {@link FilterInputStream#reset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#reset()}
   */
  @Test
  public void testReset_givenDataInputStreamResetDoesNothing_thenCallsReset() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).reset();

    // Act
    (new ResourceInputStream(is, "Name")).reset();

    // Assert that nothing has changed
    verify(is).reset();
  }

  /**
   * Test {@link ResourceInputStream#reset()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#reset()} throw
   * {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#reset()}
   */
  @Test
  public void testReset_givenDataInputStreamResetThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(is).reset();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).reset());
    verify(is).reset();
  }

  /**
   * Test {@link ResourceInputStream#skip(long)}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#skip(long)} throw
   * {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  public void testSkip_givenDataInputStreamSkipThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.skip(anyLong())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).skip(1L));
    verify(is).skip(eq(1L));
  }

  /**
   * Test {@link ResourceInputStream#skip(long)}.
   * <ul>
   *   <li>Then {@link ResourceInputStream#ResourceInputStream(InputStream, String)}
   * with is is {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} and
   * {@code Name} read is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  public void testSkip_thenResourceInputStreamWithIsIsByteArrayInputStreamAndNameReadIsSeven() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act and Assert
    assertEquals(1L, resourceInputStream.skip(1L));
    byte[] bytes = new byte[7];
    assertEquals(7, resourceInputStream.read(bytes));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), bytes);
  }
}
