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
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ResourceInputStreamDiffblueTest {
  @MockBean
  private ResourceInputStream resourceInputStream;

  /**
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
   * Method under test: {@link ResourceInputStream#getName()}
   */
  @Test
  public void testGetName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).getName());
    assertEquals("Name", (new ResourceInputStream(mock(DataInputStream.class), "Name")).getName());
  }

  /**
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
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
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
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  public void testNewResourceInputStream3() throws IOException {
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
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  public void testNewResourceInputStream4() throws IOException {
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
   * Method under test:
   * {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}
   */
  @Test
  public void testNewResourceInputStream5() throws IOException {
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
   * Method under test: {@link ResourceInputStream#toString()}
   */
  @Test
  public void testToString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("Name",
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).toString());
    assertEquals("Name", (new ResourceInputStream(mock(DataInputStream.class), "Name")).toString());
  }

  /**
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  public void testAvailable() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8,
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).available());
    assertEquals(-1, (new ResourceInputStream(null, "Name", new ArrayList<>())).available());
  }

  /**
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  public void testAvailable2() throws IOException {
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
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  public void testAvailable3() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.available()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).available());
    verify(is).available();
  }

  /**
   * Method under test: {@link ResourceInputStream#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).close();

    // Act
    (new ResourceInputStream(is, "Name")).close();

    // Assert that nothing has changed
    verify(is).close();
  }

  /**
   * Method under test: {@link ResourceInputStream#close()}
   */
  @Test
  public void testClose2() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(is).close();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).close());
    verify(is).close();
  }

  /**
   * Method under test: {@link ResourceInputStream#mark(int)}
   */
  @Test
  public void testMark() {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).mark(anyInt());

    // Act
    (new ResourceInputStream(is, "Name")).mark(1);

    // Assert that nothing has changed
    verify(is).mark(eq(1));
  }

  /**
   * Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        (new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")).markSupported());
  }

  /**
   * Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported2() {
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
   * Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  public void testMarkSupported3() {
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
   * Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  public void testRead() throws IOException {
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
   * Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  public void testRead2() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(1);

    // Act
    int actualReadResult = (new ResourceInputStream(is, "Name")).read();

    // Assert
    verify(is).read();
    assertEquals(1, actualReadResult);
  }

  /**
   * Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  public void testRead3() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).read());
    verify(is).read();
  }

  /**
   * Method under test: {@link ResourceInputStream#read(byte[])}
   */
  @Test
  public void testRead4() throws IOException {
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
   * Method under test: {@link ResourceInputStream#read(byte[], int, int)}
   */
  @Test
  public void testRead5() throws IOException {
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
   * Method under test: {@link ResourceInputStream#reset()}
   */
  @Test
  public void testReset() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doNothing().when(is).reset();

    // Act
    (new ResourceInputStream(is, "Name")).reset();

    // Assert that nothing has changed
    verify(is).reset();
  }

  /**
   * Method under test: {@link ResourceInputStream#reset()}
   */
  @Test
  public void testReset2() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(is).reset();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).reset());
    verify(is).reset();
  }

  /**
   * Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  public void testSkip() throws IOException {
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
   * Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  public void testSkip2() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.skip(anyLong())).thenReturn(1L);

    // Act
    long actualSkipResult = (new ResourceInputStream(is, "Name")).skip(1L);

    // Assert
    verify(is).skip(eq(1L));
    assertEquals(1L, actualSkipResult);
  }

  /**
   * Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  public void testSkip3() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.skip(anyLong())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> (new ResourceInputStream(is, "Name")).skip(1L));
    verify(is).skip(eq(1L));
  }
}
