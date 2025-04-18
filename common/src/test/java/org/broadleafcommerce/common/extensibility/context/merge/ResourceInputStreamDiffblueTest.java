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
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ResourceInputStreamDiffblueTest {
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
   *   <li>Given {@link ResourceInputStream#ResourceInputStream(InputStream, String)} with is is {@code null} and {@code Name}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceInputStream.available()"})
  public void testAvailable_givenResourceInputStreamWithIsIsNullAndName_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new ResourceInputStream(null, "Name")).available());
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
}
