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
package org.broadleafcommerce.common.extensibility.context.merge;

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
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ResourceInputStreamDiffblueTest {
  /**
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String)}.
   * <p>
   * Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String)"})
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
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   * <p>
   * Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
  public void testNewResourceInputStream2() throws IOException {
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
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
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
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
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
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ResourceInputStream.getNames()"})
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
   * <p>
   * Method under test: {@link ResourceInputStream#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceInputStream.getName()"})
  public void testGetName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).getName());
  }

  /**
   * Test {@link ResourceInputStream#toString()}.
   * <p>
   * Method under test: {@link ResourceInputStream#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceInputStream.toString()"})
  public void testToString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).toString());
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceInputStream.available()"})
  public void testAvailable_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnEight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).available());
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceInputStream.available()"})
  public void testAvailable_givenIOExceptionWithFoo_thenReturnMinusOne() throws IOException {
    // Arrange
    new IOException("foo");

    // Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceInputStream.available()"})
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
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#close()} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#close()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceInputStream.close()"})
  public void testClose_givenDataInputStreamCloseThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(is).close();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).close());
    verify(is).close();
  }

  /**
   * Test {@link ResourceInputStream#markSupported()}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#markSupported()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceInputStream.markSupported()"})
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
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceInputStream.markSupported()"})
  public void testMarkSupported_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).markSupported());
  }

  /**
   * Test {@link ResourceInputStream#read(byte[])} with {@code bytes}.
   * <p>
   * Method under test: {@link ResourceInputStream#read(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceInputStream.read(byte[])"})
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
   * Test {@link ResourceInputStream#read(byte[], int, int)} with {@code bytes}, {@code i}, {@code i1}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#read(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceInputStream.read(byte[], int, int)"})
  public void testReadWithBytesII1_thenReturnOne() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, resourceInputStream.read(bytes, 1, 1));
    byte[] bytes2 = new byte[7];
    assertEquals(7, resourceInputStream.read(bytes2));
    assertArrayEquals("AAAXAXAX".getBytes("UTF-8"), bytes);
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), bytes2);
  }

  /**
   * Test {@link ResourceInputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceInputStream.read()"})
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
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#read()} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceInputStream.read()"})
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
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#reset()} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceInputStream.reset()"})
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
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceInputStream.skip(long)"})
  public void testSkip_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnOne() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act and Assert
    assertEquals(1L, resourceInputStream.skip(1L));
    byte[] bytes = new byte[7];
    assertEquals(7, resourceInputStream.read(bytes));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#skip(long)}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#skip(long)} throw {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ResourceInputStream.skip(long)"})
  public void testSkip_givenDataInputStreamSkipThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.skip(anyLong())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).skip(1L));
    verify(is).skip(eq(1L));
  }
}
