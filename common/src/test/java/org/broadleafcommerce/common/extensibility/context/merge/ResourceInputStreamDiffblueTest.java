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
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
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
   *
   * <p>Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String)"})
  public void testNewResourceInputStream() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    byte[] bytes = new byte[8];
    int actualReadResult = new ResourceInputStream(is, "Name").read(bytes);
    int actualReadResult2 = is.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
  public void testNewResourceInputStream_given42_whenArrayListAdd42() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<String> previousNames = new ArrayList<>();
    previousNames.add("42");
    previousNames.add("foo");

    // Act
    ResourceInputStream actualResourceInputStream =
        new ResourceInputStream(is, "Name", previousNames);

    // Assert
    byte[] bytes = new byte[8];
    int actualReadResult = actualResourceInputStream.read(bytes);
    int actualReadResult2 = is.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
  public void testNewResourceInputStream_givenFoo_whenArrayListAddFoo() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<String> previousNames = new ArrayList<>();
    previousNames.add("foo");

    // Act
    ResourceInputStream actualResourceInputStream =
        new ResourceInputStream(is, "Name", previousNames);

    // Assert
    byte[] bytes = new byte[8];
    int actualReadResult = actualResourceInputStream.read(bytes);
    int actualReadResult2 = is.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
  public void testNewResourceInputStream_whenEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ResourceInputStream actualResourceInputStream =
        new ResourceInputStream(is, "", new ArrayList<>());

    // Assert
    byte[] bytes = new byte[8];
    int actualReadResult = actualResourceInputStream.read(bytes);
    int actualReadResult2 = is.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
  public void testNewResourceInputStream_whenName() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ResourceInputStream actualResourceInputStream =
        new ResourceInputStream(is, "Name", new ArrayList<>());

    // Assert
    byte[] bytes = new byte[8];
    int actualReadResult = actualResourceInputStream.read(bytes);
    int actualReadResult2 = is.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#ResourceInputStream(InputStream, String, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#ResourceInputStream(InputStream, String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceInputStream.<init>(InputStream, String, List)"})
  public void testNewResourceInputStream_whenNull() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ResourceInputStream actualResourceInputStream =
        new ResourceInputStream(is, null, new ArrayList<>());

    // Assert
    byte[] bytes = new byte[8];
    int actualReadResult = actualResourceInputStream.read(bytes);
    int actualReadResult2 = is.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#getNames()}.
   *
   * <p>Method under test: {@link ResourceInputStream#getNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ResourceInputStream.getNames()"})
  public void testGetNames() throws UnsupportedEncodingException {
    // Arrange and Act
    List<String> actualNames =
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")
            .getNames();

    // Assert
    assertEquals(1, actualNames.size());
    assertEquals("Name", actualNames.get(0));
  }

  /**
   * Test {@link ResourceInputStream#getName()}.
   *
   * <p>Method under test: {@link ResourceInputStream#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceInputStream.getName()"})
  public void testGetName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")
            .getName());
  }

  /**
   * Test {@link ResourceInputStream#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code foo : Name}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceInputStream.toString()"})
  public void testToString_givenArrayListAddFoo_thenReturnFooName()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> previousNames = new ArrayList<>();
    previousNames.add("foo");
    ResourceInputStream resourceInputStream =
        new ResourceInputStream(
            new ByteArrayInputStream("AdAdAdAd".getBytes("UTF-8")), "Name", previousNames);

    // Act and Assert
    assertEquals("foo : Name", resourceInputStream.toString());
  }

  /**
   * Test {@link ResourceInputStream#toString()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceInputStream.toString()"})
  public void testToString_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnName()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")
            .toString());
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourceInputStream.available()"})
  public void testAvailable_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnEight()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        8,
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")
            .available());
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#available()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourceInputStream.available()"})
  public void testAvailable_givenDataInputStreamAvailableThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.available()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new ResourceInputStream(is, "Name").available());
    verify(is).available();
  }

  /**
   * Test {@link ResourceInputStream#available()}.
   *
   * <ul>
   *   <li>Given {@link ResourceInputStream#ResourceInputStream(InputStream, String)} with is is
   *       {@code null} and {@code Name}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#available()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourceInputStream.available()"})
  public void testAvailable_givenResourceInputStreamWithIsIsNullAndName_thenReturnMinusOne()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, new ResourceInputStream(null, "Name").available());
  }

  /**
   * Test {@link ResourceInputStream#markSupported()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#markSupported()} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceInputStream.markSupported()"})
  public void testMarkSupported_givenDataInputStreamMarkSupportedReturnFalse_thenReturnFalse() {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.markSupported()).thenReturn(false);

    // Act
    boolean actualMarkSupportedResult = new ResourceInputStream(is, "Name").markSupported();

    // Assert
    verify(is).markSupported();
    assertFalse(actualMarkSupportedResult);
  }

  /**
   * Test {@link ResourceInputStream#markSupported()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#markSupported()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceInputStream.markSupported()"})
  public void testMarkSupported_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")
            .markSupported());
  }

  /**
   * Test {@link ResourceInputStream#read(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link ResourceInputStream#read(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourceInputStream.read(byte[])"})
  public void testReadWithBytes() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream =
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act
    int actualReadResult = resourceInputStream.read("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    int actualReadResult2 = resourceInputStream.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
  }

  /**
   * Test {@link ResourceInputStream#read(byte[], int, int)} with {@code bytes}, {@code i}, {@code
   * i1}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#read(byte[], int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourceInputStream.read(byte[], int, int)"})
  public void testReadWithBytesII1_thenReturnOne() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream =
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");
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
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourceInputStream.read()"})
  public void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream =
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act and Assert
    assertEquals(65, resourceInputStream.read());
    byte[] bytes = new byte[7];
    assertEquals(7, resourceInputStream.read(bytes));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#read()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ResourceInputStream.read()"})
  public void testRead_givenDataInputStreamReadThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new ResourceInputStream(is, "Name").read());
    verify(is).read();
  }

  /**
   * Test {@link ResourceInputStream#reset()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#reset()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#reset()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceInputStream.reset()"})
  public void testReset_givenDataInputStreamResetThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    doThrow(new IOException()).when(is).reset();

    // Act and Assert
    assertThrows(IOException.class, () -> new ResourceInputStream(is, "Name").reset());
    verify(is).reset();
  }

  /**
   * Test {@link ResourceInputStream#skip(long)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ResourceInputStream.skip(long)"})
  public void testSkip_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnOne()
      throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream =
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act and Assert
    assertEquals(1L, resourceInputStream.skip(1L));
    byte[] bytes = new byte[7];
    assertEquals(7, resourceInputStream.read(bytes));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link ResourceInputStream#skip(long)}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#skip(long)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInputStream#skip(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ResourceInputStream.skip(long)"})
  public void testSkip_givenDataInputStreamSkipThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.skip(anyLong())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new ResourceInputStream(is, "Name").skip(1L));
    verify(is).skip(1L);
  }
}
